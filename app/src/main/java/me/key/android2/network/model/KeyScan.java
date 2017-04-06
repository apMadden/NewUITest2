package me.key.android2.network.model;

import java.util.Random;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class KeyScan implements JSONFromServer {
    public static final String DEFAULT_ID = "-99";

    /*
     A Merged version of properties for a scan and key
     */
    public String id = DEFAULT_ID;
    public String object = "";
    public String token = "";
    public String name = "";
    public String status = "";
    public int wait_time = 99;
    public String promotion_code = "";
    public boolean cancelable = true;
    public Integer requested_images = 0;
    public double cost;
    public double total_cost = 0.0;
    public String message = "";
    public String long_message = "";
    public Key key = null;
    public Milling milling;
    public Integer code_status = 99;
    public String code[] = null;
    public String code_message = "";
    public boolean isKey = false;
    public boolean isScan = false;
    public boolean isUpdating = false;


    public boolean isUpdating() {
        return isUpdating;
    }

    public void setUpdating(boolean isUpdating) {
        this.isUpdating = isUpdating;
    }

    @Override
    public KeyScan preProcess() {
        return this;
    }

    public static KeyScan createEmptyScan() {
        KeyScan emptyScan = new KeyScan();
        emptyScan.status = "empty";
        return emptyScan;
    }

    public void assignRandomId() {
        Random r = new Random();
        id = "tmp_" + Integer.toString(r.nextInt());
    }
}
