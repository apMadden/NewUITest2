package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class ShareList implements JSONFromServer {

    public List<Share> data;
    public int total_objects;
    private String object = "";

    @Override
    public ShareList preProcess() {
        if (data == null)
            data = new ArrayList<Share>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }
}
