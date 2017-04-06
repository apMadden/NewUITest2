package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class UpdateScan implements JSONToServer {
    public String id = "";
    public String[] image_tokens = null;

    // update imageTokens
    public UpdateScan(String id, String[] image_tokens) {
        this.id = id;
        this.image_tokens = image_tokens;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
