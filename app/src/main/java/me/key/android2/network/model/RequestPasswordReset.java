package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class RequestPasswordReset implements JSONToServer {
    /*
	 * Returns {
			    "success": true
			  }
	 */

    public String email = "";

    // update email
    public RequestPasswordReset(String email) {
        this.email = email;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
