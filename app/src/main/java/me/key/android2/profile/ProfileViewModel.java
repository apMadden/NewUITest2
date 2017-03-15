package me.key.android2.profile;

import me.key.android2.KeyMeViewModel;

/**
 * Created by Andy on 3/14/2017.
 */

public class ProfileViewModel extends KeyMeViewModel {

    private String emailAddress;
    private String ccText;

    public ProfileViewModel(String emailAddress, String ccText) {
        this.emailAddress = emailAddress;
        this.ccText = ccText;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCcText() {
        return ccText;
    }

    public void setCcText(String ccText) {
        this.ccText = ccText;
    }
}
