package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Transaction implements JSONFromServer {
    /*
  {
    "object": "transaction",
    "type": "mail_order",
    "data": {}
  } */

    public String object = "";
    public String type = "mail_order";
    public BaseTransactionData data;
    public boolean isKey;
    public boolean isMobileScan = false;
    public int quantity = 0;
    public String id = "-99";
    public String promotion = "";
    public String message = "";

    public Transaction(Key key, StyleItem style, int quantity) {
        this.isKey = true;
        this.quantity = quantity;
        this.data = new BaseTransactionData(key, style);
        this.id = buildTransactionId(key, style);
    }

    public Transaction(KeyScan keyScan, int quantity) {
        this.isMobileScan = true;
        this.quantity = quantity;
        this.data = new BaseTransactionData(keyScan);
        this.id = keyScan.id;
    }

    public Transaction(AccessoryItem accessory, int quantity) {
        this.quantity = quantity;
        this.isKey = false;
        this.data = new BaseTransactionData(accessory);
        this.id = buildTransactionId(accessory);
    }

    public Transaction preProcess() {
        return this;
    }

    public static String buildTransactionId(KeyScan keyScan) {
        return keyScan.id;
    }

    public static String buildTransactionId(Key key, StyleItem style) {
        return key.id + "-" + style.id;
    }

    public static String buildTransactionId(AccessoryItem accessory) {
        return accessory.id;
    }

    public boolean hasMobileScan() {
        return (data != null && data.keyScan != null);
    }

    public boolean hasStyle() {
        return (data != null && data.style != null);
    }

    public boolean hasAccessory() {
        return (data != null && data.accessory != null);
    }

    public static class BaseTransactionData implements JSONFromServer {
        public String key_id;
        public String mobile_scan_id;
        public String style_id;
        public String accessory_id;
        public Key key;
        public KeyScan keyScan;
        public StyleItem style;
        public AccessoryItem accessory;

        public BaseTransactionData(KeyScan keyScan) {
            this.keyScan = keyScan;
            this.mobile_scan_id = (keyScan != null) ? keyScan.id : "-1";
        }

        public BaseTransactionData(Key key, StyleItem style) {
            this.key = key;
            this.style = style;
            this.key_id = (key != null) ? key.id : "-1";
            this.style_id = (key != null && style != null) ? style.id : "-1";
        }

        public BaseTransactionData(AccessoryItem accessory) {
            this.accessory = accessory;
            this.accessory_id = (accessory != null) ? accessory.id : "-1";
        }

        @Override
        public Object preProcess() {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
