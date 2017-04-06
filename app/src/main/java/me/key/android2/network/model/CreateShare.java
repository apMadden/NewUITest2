package me.key.android2.network.model;

import java.util.ArrayList;

import me.key.android.net.NetworkRequest.JSONToServer;

public class CreateShare implements JSONToServer {

    public ArrayList<String> key_ids;
    public ArrayList<String> scan_ids;
    public ArrayList<ShareReceiver> to;

    public CreateShare(ArrayList<ShareReceiver> to, ArrayList<String> share_ids, boolean isScan) {
        this.to = to;
        if (isScan) {
            this.key_ids = new ArrayList<>();
            this.scan_ids = share_ids;
        } else {
            this.key_ids = share_ids;
            this.scan_ids = new ArrayList<>();
        }
    }

    @Override
    public void process() {

    }

    public boolean sharedWithPhone() {
        return to.get(0).email == null || to.get(0).email == "";
    }
}
