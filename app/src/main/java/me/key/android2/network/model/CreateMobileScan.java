package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class CreateMobileScan implements JSONToServer {

	/*
	 * Example Request
	{
	    "name": "my key",
	    "image_tokens": [ "token1", "token2" ]
	  }
	 */

    public String name = "";
    public String image_tokens[] = null;


    public CreateMobileScan(String name, String[] image_tokens) {
        this.name = name;
        this.image_tokens = image_tokens;
    }

    @Override
    public void process() {

    }

}
