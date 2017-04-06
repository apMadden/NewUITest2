package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class UpdateUserPassword implements JSONToServer {
    /*
	 * Returns { "id": 5, "object": "user", "token": "dfasdf9a8s92jrjfkasjdf",
	 * "email": "address@domain.com", "keys": [], "scans": [] }
	 */

    public String current_password = "";
    public String password = "";
    public String password_confirmation = "";


    public UpdateUserPassword(String current_password, String password,
                              String password_confirmation) {
        this.current_password = current_password;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
