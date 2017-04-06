package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Shipping implements JSONFromServer {
    /*
 {
    "object": "shipment",
    "full_name": "John Doe",
    "address1": "123 Fake Street",
    "address2": "Apartment 4",
    "city": "Sometown",
    "state": "NA",
    "zip_code": "11234"
  }
  
	 * */

    public String object = "";
    public String full_name = "";
    public String address1 = "";
    public String address2 = "";
    public String city = "";
    public String state = "";
    public String zip_code = "";

    public Shipping(String full_name, String address1, String address2, String city, String state, String zip_code) {
        this.full_name = full_name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }

    public Shipping preProcess() {

        return this;
    }
}
