package me.key.android2.network.model;

import java.util.ArrayList;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class MobileScanList implements JSONFromServer {

    public ArrayList<MobileScan> data;
    public int total_objects;
    private String object = "";

    @Override
    public MobileScanList preProcess() {
        if (data == null)
            data = new ArrayList<MobileScan>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }

}
