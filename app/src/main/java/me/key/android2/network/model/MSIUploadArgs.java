package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;
import me.key.android.net.NetworkRequest.JSONToServer;

public class MSIUploadArgs implements JSONFromServer, JSONToServer {
    /*
  {
        "object" : "mobile_scan_image",
        "token" : "k-hQoHtCLC3hpUgdtDxs-w",
        "upload_url" : "https://mobile_scan_images.s3.amazonaws.com",
        "upload_args" : {
            "key" : "beta/000/000/001/original.jpg",
            "AWSAccessKeyId" : "AKIAJL6ZXQNRJKF2CB6A",
            "acl" : "private",
            "policy" : "eyJleHBpcmF0aW9uIjoiMjAxNC0wNi0yMFQxNTozMToxOVoiLCJjb25kaXRpb25zIjpbeyJidWNrZXQiOiJtb2JpbGVfc2Nhbl9pbWFnZXMifSx7ImtleSI6ImJldGEvMDAwLzAwMC8wMDEvb3JpZ2luYWwuanBnIn0seyJhY2wiOiJwcml2YXRlIn0sWyJzdGFydHMtd2l0aCIsIiRDb250ZW50LVR5cGUiLCJpbWFnZS8iXSxbImNvbnRlbnQtbGVuZ3RoLXJhbmdlIiwwLDgzODg2MDhdXX0=",
            "signature" : "LcHxoSKUFYg9hbAfsypkE0IHbtY="
        }
    }
  
	 * */

    public String key = "";
    public String AWSAccessKeyId = "";
    public String acl = "";
    public String policy = "";
    public String signature = "";

    public MSIUploadArgs(String key, String AWSAccessKeyId, String acl, String policy, String signature) {

    }

    public MSIUploadArgs preProcess() {

        return this;
    }

    @Override
    public void process() {
        // TODO Auto-generated method stub

    }
}
