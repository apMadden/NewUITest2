package me.key.android2.network.model;

import java.util.ArrayList;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class CurrentScanImage implements JSONFromServer {
    public static int STATUS_NEW = 1;
    public static int STATUS_USED = 2;
    public ArrayList<MobileScanImage> data = new ArrayList<MobileScanImage>();
    private String object = "";
    private int status = STATUS_NEW;
    private String name = "";
    private String answers = "";

    @Override
    public CurrentScanImage preProcess() {
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void addMobileScanImage(MobileScanImage image) {
        data = (data == null) ? new ArrayList<MobileScanImage>() : data;
        data.add(image);
    }

    public MobileScanImage getFirstScan() {
        MobileScanImage image = null;
        if (data != null) {
            image = data.get(0);
        }
        return image;
    }

    public MobileScanImage getSecondScan() {
        MobileScanImage image = null;
        if (data != null) {
            image = data.get(1);
        }
        return image;
    }

    /**
     * gets the next available scan token with no assigned local file and assigns the localfile
     **/
//	public MobileScanImage getAvailableScan() {
//		MobileScanImage image = getFirstScan();
//		
//		//Based on whether or not the scan has a local file assigned.
//		String firstImage = image.getLocalFilePath();
//		if(firstImage != null && !firstImage.equals("")){
//			image = getSecondScan();
//		}
//		
//		return image;
//	}
    public String[] getTokens() {
        ArrayList<String> tokens = new ArrayList<String>();

        for (int i = 0; data.size() > i; i++) {
            MobileScanImage image = data.get(i);
            tokens.add((image != null && image.token != null) ? data.get(i).token : "");
        }

        String[] returnArray = new String[tokens.size()];
        return tokens.toArray(returnArray);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }


//	public String getScanTokenByKey(String key) {
//		MobileScanImage item = getFirstScan();
//		if(item.upload_args.key == key){
//			return item.token;
//		}
//		item = getSecondScan();
//		if(item.upload_args.key == key){
//			return item.token;
//		}
//		return null;
//	}
}
