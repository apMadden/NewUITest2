package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class Register implements JSONToServer {
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

    public String password = "";
    public String password_confirmation = "";
    public String email = "";

    public Register(String email, String password, String password_confirmation) {
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
