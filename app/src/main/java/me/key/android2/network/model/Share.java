package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Share implements JSONFromServer {
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
    public String id = "-99";
    public String object = "";
    public Key key = null;
    public MobileScan scan = null;
    public String key_name = "";
    public String from = "";
    public ShareReceiver to;
    public String status = "";
    public String instructions = "";


    @Override
    public Share preProcess() {


        return this;
    }


}
