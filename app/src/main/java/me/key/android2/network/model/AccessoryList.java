package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class AccessoryList implements JSONFromServer {

    public List<AccessoryItem> data;
    private String object = "";
    public String id;

    @Override
    public AccessoryList preProcess() {
        if (data == null)
            data = new ArrayList<AccessoryItem>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }

}
