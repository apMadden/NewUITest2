package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class Kiosk implements JSONFromServer {
    /*
  {
    "id": 530,
    "object": "kiosk",
    "name": "Some 7-11 Kiosk",
    "address": "123 Fake Street",
    "hours_of_operation": "9 AM - 5 PM"
    "phone_number": "(555) 555-5555"
    "latitude": 94.355,
    "longitude": 120.34,
    "distance": 234.20
    "store_name": Bed Bath and Beyond
  }
  
     * */
    public String id = "-99";
    public String object = "";
    public String token = "";
    public String name = "";
    public String address = "";
    public String hours_of_operation = "";
    public String phone_number = "";
    public String store_name = "";
    public double latitude = 0.0;
    public double longitude = 0.0;
    public double distance = 0.0;


    @Override
    public Kiosk preProcess() {


        return this;
    }
}
