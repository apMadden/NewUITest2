package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class StyleItem implements JSONFromServer {
    /*
  {
    "id": 4,
    "object": "style",
    "name": "some style",
    "cost": 4.0,
    "category": { },
    "images" : {
        "standard": "url_to_image",
        "retina": "url_to_image"
    }
  }
  
	 * */

    public String id = "-99";
    public String object = "";
    public String name = "";
    public Double cost = 0.0;
    public StyleCategoryItem category;
    public ImagesObject images;
    public Double total_cost = 0.0;

    public StyleItem preProcess() {

        return this;
    }

    public static class ImagesObject {
        public String standard;
        public String retina;

    }
}
