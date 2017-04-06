package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class UpdateUserEmail implements JSONToServer {
    /*
	 * Returns { "id": 5, "object": "user", "token": "dfasdf9a8s92jrjfkasjdf",
	 * "email": "address@domain.com", "keys": [], "scans": [] }
	 */

    //public String current_password = "";
    public String email = "";
    //public String email_confirmation = "";

    // update email
    public UpdateUserEmail(String email, String email_confirmation) {
        this.email = email;
        //this.email_confirmation = email_confirmation;
        //this.current_password = password;
    }

    public UpdateUserEmail(String email) {
        this.email = email;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
