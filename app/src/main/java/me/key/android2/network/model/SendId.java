package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class SendId implements JSONToServer {

    public String id = "-99";

    public SendId(String id) {
        this.id = id;
    }

    @Override
    public void process() {

    }


}
