package me.key.android2.keychain.viewmodels;

import android.view.View;

import me.key.android2.KeyMeViewModel;

/**
 * Created by Andy on 3/17/2017.
 */

public class ScanANewKeyViewModel extends KeyMeViewModel {
    private String scanKeyBannerUrl;

    public ScanANewKeyViewModel(String scanKeyBannerUrl) {
        this.scanKeyBannerUrl = scanKeyBannerUrl;
    }

    public String getKioskImageUrl() {
        return scanKeyBannerUrl;
    }

    public void setKioskImageUrl(String scanKeyBannerUrl) {
        this.scanKeyBannerUrl = scanKeyBannerUrl;
    }

    public void onFindKioskClicked(View v) {

    }
}
