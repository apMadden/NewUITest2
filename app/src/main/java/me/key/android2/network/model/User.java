package me.key.android2.network.model;

import java.util.ArrayList;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class User implements JSONFromServer {
    /*
  {
    "object" : "user",
    "id" : 384,
    "email" : "bhaidaya@appstem.com",
    "token" : "Cr60GWF95XF4v1oLWxo1hQ",
    "keys" : [{
        "object" : "key",
        "id" : 1306,
        "name" : "Test Key 2",
        "code_status" : 0,
        "milling" : {
            "object" : "milling",
            "id" : 8,
            "name" : "sc4",
            "images" : {
                "standard" : "https://s3.amazonaws.com/key_milling_images/beta/sc4/standard.png?1382295766",
                "retina" : "https://s3.amazonaws.com/key_milling_images/beta/sc4/retina.png?1382295766"
            },
            "image_offsets" : {
                "retina" : 55,
                "standard" : 27
            }
        }
    }, {
        "object" : "key",
        "id" : 1305,
        "name" : "Test Key 1",
        "code_status" : 0,
        "milling" : {
            "object" : "milling",
            "id" : 1,
            "name" : "kw1",
            "images" : {
                "standard" : "https://s3.amazonaws.com/key_milling_images/beta/kw1/standard.png?1382295783",
                "retina" : "https://s3.amazonaws.com/key_milling_images/beta/kw1/retina.png?1382295783"
            },
            "image_offsets" : {
                "retina" : 50,
                "standard" : 40
            }
        }
    }],
    "scans" : [{
        "object" : "mobile_scan",
        "wait_time" : 10000,
        "message" : "Some message...",
        "id" : 2444,
        "name" : "Test",
        "status" : "review",
        "cancelable" : false
    }]
}
  
	 * */

    public String object = "";
    public String id = "";
    public String token = "";
    public String email = "";
    public String email_unchangeable = "";
    public ArrayList<Key> keys = null;
    public ArrayList<MobileScan> scans = null;

    @Override
    public User preProcess() {
        if (keys == null) {
            keys = new ArrayList<Key>();
        }
        for (int i = 0; i < keys.size(); i++)
            keys.get(i).preProcess();

        if (scans == null) {
            scans = new ArrayList<MobileScan>();
        }
        for (int i = 0; i < scans.size(); i++)
            scans.get(i).preProcess();
        return this;
    }
}
