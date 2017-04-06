package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONToServer;

public class SendLocation implements JSONToServer {
    /*
  {
    "id": 530,
    "object": "kiosk",
    "name": "Some 7-11 Kiosk",
    "address": "123 Fake Street",
    "latitude": 94.355,
    "longitude": 120.34,
    "distance": 234.20
  }
  
     * */
    public double latitude; // = 0.0;
    public double longitude;// = 0.0;
    public double distance = 10.0;

    public SendLocation(double latitude, double longitude, double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }

    public SendLocation() {

    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }


}
