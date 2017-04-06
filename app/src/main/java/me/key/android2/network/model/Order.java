package me.key.android2.network.model;

import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Order implements JSONFromServer {
    /*
	  {
    "object" : "order",
    "id" : 4397,
    "amount_paid" : 9.98,
    "delivery_method" : {
        "object" : "shipment",
        "id" : 195,
        "full_name" : "bhaidaya",
        "address1" : "123 po box",
        "address2" : null,
        "city" : "Santa cruz",
        "state" : "nm",
        "zip_code" : "12345"
    },
    "transactions" : [{
        "object" : "transaction",
        "type" : "mail_order",
        "data" : {
            "key" : {
                "object" : "key",
                "id" : 1305,
                "name" : "Test Key 1",
                "code_status" : 0,
                "milling" : {
                    "object" : "milling",
                    "id" : 1,
                    "name" : "kw1",
                    "images" : {
                        "standard" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/standard.png?1382295783",
                        "retina" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/retina.png?1382295783"
                    },
                    "image_offsets" : {
                        "retina" : 50,
                        "standard" : 40
                    }
                }
            },
            "style" : {
                "object" : "style",
                "id" : 112,
                "milling" : {
                    "object" : "milling",
                    "id" : 1,
                    "name" : "kw1",
                    "images" : {
                        "standard" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/standard.png?1382295783",
                        "retina" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/retina.png?1382295783"
                    },
                    "image_offsets" : {
                        "retina" : 50,
                        "standard" : 40
                    }
                },
                "paint_style" : {
                    "id" : 9,
                    "name" : "mustache"
                }
            }
        }
    }, {
        "object" : "transaction",
        "type" : "mail_order",
        "data" : {
            "key" : {
                "object" : "key",
                "id" : 1305,
                "name" : "Test Key 1",
                "code_status" : 0,
                "milling" : {
                    "object" : "milling",
                    "id" : 1,
                    "name" : "kw1",
                    "images" : {
                        "standard" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/standard.png?1382295783",
                        "retina" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/retina.png?1382295783"
                    },
                    "image_offsets" : {
                        "retina" : 50,
                        "standard" : 40
                    }
                }
            },
            "style" : {
                "object" : "style",
                "id" : 112,
                "milling" : {
                    "object" : "milling",
                    "id" : 1,
                    "name" : "kw1",
                    "images" : {
                        "standard" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/standard.png?1382295783",
                        "retina" : "https://s3.amazonaws.com/key_milling_images/staging/kw1/retina.png?1382295783"
                    },
                    "image_offsets" : {
                        "retina" : 50,
                        "standard" : 40
                    }
                },
                "paint_style" : {
                    "id" : 9,
                    "name" : "mustache"
                }
            }
        }
    }],
    "meta" : {
        "social_media" : {
            "message" : "Like KeyMe?  Help us spread the word (and give your friends a nice discount)!",
            "post" : "Copy keys from your phone using @KeyMe! key.me/dl",
            "image" : "https://keyme.s3.amazonaws.com/social_media_promo.jpg"
        }
    }
}
  
	 * */

    public String id = "-99";
    public String object; //order
    public List<Transaction> transactions;
    public double amount_paid;
    public Shipping delivery_method = null;
    //public String payment_receipt; // not used. ios inapp purchase receipts
    public Object meta;


    @Override
    public Order preProcess() {


        return this;
    }

}
