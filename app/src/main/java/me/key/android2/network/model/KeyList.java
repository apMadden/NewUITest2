package me.key.android2.network.model;

import java.util.ArrayList;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class KeyList implements JSONFromServer {

    public ArrayList<Key> data;
    public int total_objects;
    private String object = "";

    @Override
    public KeyList preProcess() {
        if (data == null)
            data = new ArrayList<Key>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }

}
