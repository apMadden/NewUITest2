package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class AcceptShare implements JSONToServer {

    public String token = "";
    public String sent_to;

    public AcceptShare(String token, String sent_to) {
        this.token = token;
        this.sent_to = sent_to;
    }

    @Override
    public void process() {

    }

}
