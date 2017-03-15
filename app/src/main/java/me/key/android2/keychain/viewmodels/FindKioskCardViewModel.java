package me.key.android2.keychain.viewmodels;

import android.view.View;

import me.key.android2.KeyMeViewModel;
import me.key.android2.keychain.KeyChainViewModel;

/**
 * Created by Andy on 3/14/2017.
 */


public class FindKioskCardViewModel extends KeyMeViewModel {
    private String kioskImageUrl;

    public FindKioskCardViewModel(String kioskImageUrl) {
        this.kioskImageUrl = kioskImageUrl;
    }

    public String getKioskImageUrl() {
        return kioskImageUrl;
    }

    public void setKioskImageUrl(String kioskImageUrl) {
        this.kioskImageUrl = kioskImageUrl;
    }

    public void onFindKioskClicked(View v) {

    }
}
