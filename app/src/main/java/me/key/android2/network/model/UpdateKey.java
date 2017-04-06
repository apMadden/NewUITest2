package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class UpdateKey implements JSONToServer {
    public String id = "";
    public String name = "";

    public UpdateKey(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
