package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class StyleCategoryItem implements JSONFromServer {
    /*
	{
	  "id": "key-category",
	  "object": "style_category",
	  "name": "Key Category"
	}
  
	 * */

    public String id = "";
    public String object = "";
    public String name = "";

    public StyleCategoryItem preProcess() {

        return this;
    }

}
