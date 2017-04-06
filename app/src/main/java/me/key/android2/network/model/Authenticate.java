package me.key.android2.network.model;

public class Authenticate implements JSONToServer {
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
    public String email = "";

    public Authenticate(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
