package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class MobileScanImage implements JSONFromServer {
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

    public String object = "";
    public String token = "";
    public String upload_url = "";
    public MSIUploadArgs upload_args = null;
    private String local_file = "";
    private boolean uploaded = false;
    private boolean hasFile = false;

    public MobileScanImage preProcess() {

        return this;
    }

    public String getLocalFilePath() {
        return local_file;
    }

    public void setLocalFilePath(String local_file) {
        this.local_file = local_file;
        hasFile = true;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public boolean hasFile() {
        return hasFile;
    }

}
