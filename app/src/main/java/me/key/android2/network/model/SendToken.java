package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;
import me.key.android.net.NetworkRequest.JSONToServer;

public class SendToken implements JSONToServer, JSONFromServer {

    public String token = "";

    public SendToken(String token) {
        this.token = token;
    }

    @Override
    public void process() {

    }

    @Override
    public Object preProcess() {
        // TODO Auto-generated method stub
        return null;
    }

}
