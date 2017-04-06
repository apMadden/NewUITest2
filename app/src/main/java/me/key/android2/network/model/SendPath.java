package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class SendPath implements JSONToServer {

    public String path = "";

    public SendPath(String path) {
        this.path = path;
    }

    @Override
    public void process() {

    }


}
