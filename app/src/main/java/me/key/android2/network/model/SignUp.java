package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class SignUp implements JSONFromServer {
    /*
  {
    "id": 5,
    "object": "user",
    "token": "dfasdf9a8s92jrjfkasjdf",
    "email": "address@domain.com",
    "keys": [],
    "scans": []
  }
  
	 * */

    public String obj = "";
    public String token = "";
    public String email = "";
    public String keys = "";
    public String scans = "";
//	
//	public List<String> screenshot_urls;
//	
//	public boolean is_purchased;
//	public String last_modified_by = "";
//	public String navionics_product_id = "";
//	public boolean bought;
//	
//	// public List<String> needs_product; ??? not sure type
//	
//	public String expired_at = "";
//	public boolean expired;
//	
//	public int product_duration;
//	public int duration;
//	public int priority;
//	
//	public String region_code = "";

    @Override
    public SignUp preProcess() {
//		if (screenshot_urls == null)
//			screenshot_urls = new ArrayList<String>();
        return this;
    }
}
