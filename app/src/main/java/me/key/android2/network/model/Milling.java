package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Milling implements JSONFromServer {
    /*
  {
    "id": 34,
    "object": "milling",
    "name": "kw1",
    "images": {
      "standard": "url_to_image",
      "retina": "url_to_image"
    },
    "image_offsets": {
      "standard": 10,
      "retina": 20
    }
  }
  
	 * */

    public String object = "";
    public String id = "-99";
    public String name = "";
    public ImagesObject images;
    public ImageOffsetsObject image_offsets;


    @Override
    public Milling preProcess() {


        return this;
    }

    public static class ImagesObject {
        public String standard;
        public String retina;

    }

    public static class ImageOffsetsObject {
        public int standard;
        public int retina;

    }
}
