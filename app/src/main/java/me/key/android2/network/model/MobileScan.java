package me.key.android2.network.model;


public class MobileScan extends KeyScan {
    /*
 {
    "id": 346,
    "object": "mobile_scan",
    "token": "idasf98sf1oejkda0d",
    "name": "my key",
    "status": "pending",
    "wait_time": 3,
    "promotion_code": "oh_no",
    "cancelable": false,
    "requested_images": 0,
    "message": "Please supply answers to the following questions...",
    "key": {}
  }
  
	 * */
//	public String id = "-99";
//	public String object = "";
//	public String token = "";
//	public String name = "";
//	public String status = "";
//	public int wait_time = 99;
//	public String promotion_code = "";
//	public boolean cancelable = true;
//	public int requested_images = 0;
//	public String message = "";
//	public Key key = null;

    public MobileScan() {
        isScan = true;
    }

    @Override
    public MobileScan preProcess() {
//		if (screenshot_urls == null)
//			screenshot_urls = new ArrayList<String>();

        return this;
    }
}
