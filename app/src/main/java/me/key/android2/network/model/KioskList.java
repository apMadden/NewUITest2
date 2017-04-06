package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class KioskList implements JSONFromServer {

    public List<Kiosk> data;
    public int total_objects;
    private String object = "";

    @Override
    public KioskList preProcess() {
        if (data == null)
            data = new ArrayList<Kiosk>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }
}
