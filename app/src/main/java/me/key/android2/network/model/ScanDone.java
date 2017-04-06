package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class ScanDone implements JSONToServer {

    public String token = "";
    public int key_present = -1;

    public ScanDone(String token, int key_present) {
        this.token = token;
        this.key_present = key_present;
    }

    @Override
    public void process() {

    }
}