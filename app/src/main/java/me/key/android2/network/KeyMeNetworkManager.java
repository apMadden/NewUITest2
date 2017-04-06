package me.key.android2.network;

import android.content.Context;
import android.net.NetworkRequest;
import android.net.Uri;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.key.android.BuildConfig;
import me.key.android.net.model.AcceptShare;
import me.key.android.net.model.RenameScan;
import me.key.android.net.model.ScanDone;
import me.key.android.net.model.SendId;
import me.key.android.net.model.SendIdandCategory;
import me.key.android.net.model.SendToken;
import me.key.android.net.model.UpdateKey;
import me.key.android.net.model.UpdateScan;
import me.key.android.shared.KeyMeActivity;
import me.key.android.shared.KeyMeSettings;

public class KeyMeNetworkManager {

    public static final String TOKEN_PLACEHOLDER = "#TOKEN_PLACEHOLDER#";
    public static final String PROVIDER_PLACEHOLDER = "#PROVIDER_PLACEHOLDER#";
    public static final String ID_PLACEHOLDER = "#ID_PLACEHOLDER#";
    public static final String CATEGORY_PLACEHOLDER = "#CATEGORY_PLACEHOLDER#";
    public static final String PATH_PLACEHOLDER = "#PATH_PLACEHOLDER#";
    private Context mContext;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface RequestTag {
        KeyMeRequestType value();
    }

    public Class<? extends Annotation> getRequestTagAnnotationType() {
        return RequestTag.class;
    }

    public KeyMeNetworkActivityWorker newWorker(KeyMeActivity act) {
        this.mContext = act.getApplicationContext();
        return new KeyMeNetworkActivityWorker(act);
    }

    public Class<? extends RequestInterface> getRequestInterfaceClass() {
        return RequestInterface.class;
    }

    public boolean doCustomOffThreadRequestModification(NetworkRequest request) {
        request.addHeader("Accept", "application/json");
        request.addHeader("Content-Type", "application/json");
        request.addHeader("User-Agent", "KeyMe/android " + BuildConfig.VERSION_NAME);
        request.addHeader("KeyMe-Version", "20161222");

        KeyMeRequestType requestType = ((KeyMeRequestType) request.getRequestType());


        //Check if the Request requires Authentication
        if (requestType.usesAuthetication()) {
            //add the token to the header using Basic HTTP Authentication
            String token = KeyMeSettings.getInstance(mContext).getToken();
            if (token != null && !token.equals("")) {
                try {
                    request.addHeader("Authorization", "Basic " + Base64.encodeToString((token + ":").getBytes("UTF-8"), Base64.NO_WRAP));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        //Check if the request path needs to be edited
        if (requestType.needsUrlEdit()) {
            if (requestType == KeyMeRequestType.LOGINOTHER) {
                // put the token into the request (in either the url or as a param)
                if (request.getPath().contains(TOKEN_PLACEHOLDER)) {
                    request.setPath(request.getPath().replace(TOKEN_PLACEHOLDER, request.getParam("access_token")));
                    request.removeParam("access_token");
                }

                if (request.getPath().contains(PROVIDER_PLACEHOLDER)) {
                    request.setPath(request.getPath().replace(PROVIDER_PLACEHOLDER, request.getParam("provider")));
                    request.removeParam("provider");
                }

            } else if (requestType == KeyMeRequestType.CAPTUREMOBILESCAN) {

                String path = request.getPath().replace(TOKEN_PLACEHOLDER, request.getParam("capturetoken"));
                request.setPassValue(request.getParam("capturetoken"));
                request.removeParam("capturetoken");
                request.setPath(path);

            } else if (requestType == KeyMeRequestType.GETMOBILESCAN ||
                    requestType == KeyMeRequestType.GETKEY ||
                    requestType == KeyMeRequestType.GETSHAREWITHTOKEN ) {

                SendToken token = (SendToken) request.getJSONBody();
                String path = request.getPath().replace(TOKEN_PLACEHOLDER, token.token);
                request.setPassValue(token.token);
                request.setPath(path);

            } else if (requestType == KeyMeRequestType.CANCELMOBILESCAN ||
                    requestType == KeyMeRequestType.GETSTYLECATEGORIESLIST ||
                    requestType == KeyMeRequestType.GETSTYLEACCESSORIESLIST ||
                    requestType == KeyMeRequestType.DELETEKEY) {

                SendId id = (SendId) request.getJSONBody();
                String path = request.getPath().replace(ID_PLACEHOLDER, String.valueOf(id.id));
                request.setPassValue(String.valueOf(id.id));
                request.setPath(path);

            } else if (requestType == KeyMeRequestType.GETSTYLESLIST ||
                    requestType == KeyMeRequestType.GETKIOSKSTYLELIST) {
                //SendId id = (SendId)request.getJSONBody();
                SendIdandCategory sendCat = (SendIdandCategory) request.getJSONBody();
                String path = request.getPath().replace(ID_PLACEHOLDER, String.valueOf(sendCat.id));

                String category = sendCat.category;

                if (category == null) {
                    category = "";
                } else {
                    category = Uri.encode(category);
                }
                path = path.replace(CATEGORY_PLACEHOLDER, category);
                request.setPath(path);

            } else if (requestType == KeyMeRequestType.ACCEPTSHARE) {
                AcceptShare token = (AcceptShare) request.getJSONBody();
                String path = request.getPath().replace(TOKEN_PLACEHOLDER, token.token);
                request.setPassValue(token.token);
                request.setPath(path);
            } else if (requestType == KeyMeRequestType.UPDATEMOBILESCAN) {
                UpdateScan id = (UpdateScan) request.getJSONBody();
                String path = request.getPath().replace(ID_PLACEHOLDER, id.id);
                request.setPath(path);
            } else if (requestType == KeyMeRequestType.UPDATEKEY) {
                UpdateKey id = (UpdateKey) request.getJSONBody();
                String path = request.getPath().replace(ID_PLACEHOLDER, id.id);
                request.setPath(path);
            } else if (requestType == KeyMeRequestType.RENAMESCAN){
                RenameScan id = (RenameScan) request.getJSONBody();
                String path = request.getPath().replace(ID_PLACEHOLDER, id.id);
                request.setPath(path);
            } else if (requestType == KeyMeRequestType.MARKUPLOADMOBILESCANIMAGEDONE) {
                ScanDone token = (ScanDone) request.getJSONBody();
                String path = request.getPath().replace(TOKEN_PLACEHOLDER, token.token);
                request.setPassValue(request.getParam("imagenumber"));
                request.removeParam("imagenumber");
                request.setPath(path);

            }
        }

        //Uploading mobileScans
        if (requestType == KeyMeRequestType.UPLOADMOBILESCANIMAGE) {
            //Upload is anonymous
            request.setPath(request.getParam("path"));
            request.removeParam("path");

            request.setPassValue(request.getParam("imagenumber"));
            request.removeParam("imagenumber");

            request.addParam("Content-Type", "image/jpeg");

            request.attachFile(request.getParam("filename"));
            request.removeParam("filename");

        }
        return true;
    }
}
