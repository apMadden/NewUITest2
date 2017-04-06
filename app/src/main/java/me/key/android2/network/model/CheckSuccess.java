package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class CheckSuccess implements JSONFromServer {
    /*
  {
    "success": true
  }
  
	 * */


    public String success = "";

    @Override
    public CheckSuccess preProcess() {
        return this;
    }
}
