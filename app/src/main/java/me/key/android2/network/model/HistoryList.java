package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class HistoryList implements JSONFromServer {

    public List<HistoryItem> data;
    public int total_objects;
    private String object = "";

    @Override
    public HistoryList preProcess() {
        if (data == null)
            data = new ArrayList<HistoryItem>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }
}
