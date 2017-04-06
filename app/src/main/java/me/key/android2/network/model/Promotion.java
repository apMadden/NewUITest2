package me.key.android2.network.model;

import me.key.android.net.NetworkRequest;

/**
 * Created by andrew.madden on 8/18/16.
 */
public class Promotion implements NetworkRequest.JSONFromServer {
    /*
 {
    "app": {
        "text": "50% Off!",
        "banner": "http://some.img/url"
    }
  } */

    public PromotionObject app;

    @Override
    public Promotion preProcess() {
        return this;
    }

    public static class PromotionObject {
        public String text;
        public String banner;
    }
}