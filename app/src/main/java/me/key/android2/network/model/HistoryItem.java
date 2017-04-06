package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class HistoryItem implements JSONFromServer {
    /*
  {
    "object": "history_item",
    "date": "2013-05-07T19:40:54Z",
    "message": "You shared a key.",
    "type": "share",
    "key_id": 34,
    "scan_id": 55,
    "order_id": 62
  }
  
	 * */

    public String object = "";
    public String date = "";
    public String message = "";
    public String type = "";
    public String key_id = "";
    public String scan_id = "";
    public String order_id = "";

    public HistoryItem preProcess() {

        return this;
    }
}
