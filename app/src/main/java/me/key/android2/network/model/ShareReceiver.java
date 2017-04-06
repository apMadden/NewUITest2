package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;
import me.key.android.net.NetworkRequest.JSONToServer;

public class ShareReceiver implements JSONFromServer, JSONToServer {
    /*
  {
    "id": "sh_530",
    "object": "share",
    "key": {},
    "key_name": "my key",
    "from": "sharer@domain.com",
    "to": {
      "email": "person@domain.com",
      "phone": "2345678901"
    },
    "status": "accepted"
  }
  
     * */
    public String email;
    public String phone;

    public ShareReceiver(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    public ShareReceiver preProcess() {


        return this;
    }

    @Override
    public void process() {

    }


}

