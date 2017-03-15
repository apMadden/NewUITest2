package me.key.android2.keychain.viewmodels;

import android.view.View;

import me.key.android2.KeyMeViewModel;

/**
 * Created by Andy on 3/14/2017.
 */

public class PromoCardViewModel extends KeyMeViewModel {
    private String promoImageUrl;

    public PromoCardViewModel(String promoImageUrl) {
        this.promoImageUrl = promoImageUrl;
    }

    public String getpromoImageUrl() {
        return promoImageUrl;
    }

    public void setpromoImageUrl(String promoImageUrl) {
        this.promoImageUrl = promoImageUrl;
    }

    public void onPromoClicked(View v) {

    }
}
