package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class CreditCard implements JSONFromServer {
    /*
  {
    "object": "card",
    "available": true,
    "exp_month": 12,
    "exp_year": 2015,
    "last4": "4242",
    "type": "Visa"
  }
  
	 * */

    public String object = "";
    public Boolean available = false;
    public String exp_month = "";
    public String exp_year = "";
    public String last4 = "";
    public String type = "";


    @Override
    public CreditCard preProcess() {

        return this;
    }
}
