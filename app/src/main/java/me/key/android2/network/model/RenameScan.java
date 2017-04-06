package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class RenameScan implements JSONToServer {
    public String id = "";
    public String name = "";

    public RenameScan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void process() {

    }
}
