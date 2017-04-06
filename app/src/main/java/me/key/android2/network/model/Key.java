package me.key.android2.network.model;


public class Key extends KeyScan {

    public Key() {
        isKey = true;
    }

    @Override
    public Key preProcess() {
        return this;
    }
}
