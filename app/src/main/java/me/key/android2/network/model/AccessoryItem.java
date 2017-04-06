package me.key.android2.network.model;


import android.util.JsonReader;

public class AccessoryItem {
    /*
  {
    "id": 4,
    "object": "accessory",
    "name": "Keychain",
    "description": "Awesome!",
    "cost": 4.0,
    "images" : {
        "standard": "url_to_image",
        "retina": "url_to_image"
    }
  }
  
	 * */

    public String id = "-99";
    public String object = "";
    public String name = "";
    public String description = "";
    public Double cost = 0.0;
    public ImagesObject images;
    public Double total_cost = 0.0;

    public AccessoryItem preProcess() {

        return this;
    }

    public static class ImagesObject {
        public String standard;
        public String retina;

    }
}
