package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class Quantity implements JSONToServer {

    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void process() {


    }


}
