package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class SendIdandCategory implements JSONToServer {

    public String id = "-99";
    public String category = "";

    public SendIdandCategory(String id) {
        this.id = id;
    }

    public SendIdandCategory(String id, String category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public void process() {

    }


}
