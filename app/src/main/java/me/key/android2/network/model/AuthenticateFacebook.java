package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class AuthenticateFacebook implements JSONToServer {
    /* Returns
  {
    "id": 5,
    "object": "user",
    "token": "dfasdf9a8s92jrjfkasjdf",
    "email": "address@domain.com",
    "keys": [],
    "scans": []
  }
  
	 * */

    public String provider = "facebook_access_token";
    public String access_token = "";

    public AuthenticateFacebook(String token) {
        this.access_token = token;
    }

    @Override
    public void process() {

    }
}
