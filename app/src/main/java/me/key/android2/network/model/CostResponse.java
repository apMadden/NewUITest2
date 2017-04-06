package me.key.android2.network.model;

import java.util.Map;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class CostResponse implements JSONFromServer {
    /*
  {
    "tax" : 0.0,
    "total" : 783.33,
    "subtotal" : 783.33,
    "delivery" : 0.0,
    "item_savings" : 132.0,
    "total_savings" : 132.0,
    "delivery_savings" : 0.0,
    "groups" : {
        "mail_order" : {
            "1305-463" : 5,
            "1305-493" : 6,
            "1306-458" : 3,
            "1306-461" : 1,
            "1305-305" : 10,
            "1305-420" : 12,
            "1305-231" : 7,
            "1305-183" : 9,
            "1305-176" : 4,
            "1306-148" : 10
        }
    },
    "savings" : {
        "mail_order" : {
            "1305-463" : 10.0,
            "1305-493" : 12.0,
            "1306-458" : 6.0,
            "1306-461" : 2.0,
            "1305-305" : 20.0,
            "1305-420" : 24.0,
            "1305-231" : 14.0,
            "1305-183" : 18.0,
            "1305-176" : 8.0,
            "1306-148" : 18.0
        }
    },
    "costs" : {
        "mail_order" : {
            "1305-463" : 324.95,
            "1305-493" : 161.94,
            "1306-458" : 50.97,
            "1306-461" : 16.99,
            "1305-305" : 49.9,
            "1305-420" : 59.88,
            "1305-231" : 34.93,
            "1305-183" : 35.91,
            "1305-176" : 15.96,
            "1306-148" : 31.9
        }
    },
    "message" : "We applied the following promotion to your order: $2 off each key after the first.",
    "description" : "$2 off each key after the first"
}
  
	 * */

    /**
     * {
     * "tax" : 0.0,
     * "total" : 9.99,
     * "subtotal" : 9.99,
     * "delivery" : 0.0,
     * "item_savings" : 0.0,
     * "total_savings" : 0.0,
     * "delivery_savings" : 0.0,
     * "groups" : {
     * "code_purchase" : 1
     * },
     * "savings" : {
     * "code_purchase" : 0.0
     * },
     * "costs" : {
     * "code_purchase" : 9.99
     * },
     * "message" : ""
     * }
     */

    public String message = "";
    public GroupClass groups = null;
    public GroupClass costs = null;

    public GroupClass getCosts() {
        return costs;
    }

    public GroupClass savings = null;
    public Double delivery = 0.0;
    public Double delivery_savings = 0.0;
    public Double item_savings = 0.0;
    public Double total_savings = 0.0;
    public Double total = 0.0;
    public Double tax = 0.0;
    public Double subtotal = 0.0;

    @Override
    public CostResponse preProcess() {


        return this;
    }

    public class GroupClass implements JSONFromServer {
        public Map<String, Double> mail_order = null;
        public Map<String, Double> mobile_scan_mail_order = null;
        public Map<String, Double> accessory = null;

        @Override
        public Object preProcess() {
            // TODO Auto-generated method stub
            return null;
        }

    }

}
