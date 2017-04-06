package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class EditCard implements JSONToServer {
    /*
	  https://stripe.com/docs/mobile/android
		 * */

    public String stripe_token = ""; //USed by Stripe


    public EditCard(String stripe_token) {
        this.stripe_token = stripe_token;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
