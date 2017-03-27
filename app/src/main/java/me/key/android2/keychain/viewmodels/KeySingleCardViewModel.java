package me.key.android2.keychain.viewmodels;

import android.databinding.ObservableInt;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.view.View;

import java.util.ArrayList;

import me.key.android2.KeyMeViewModel;
import me.key.android2.keychain.KeyChainViewModel;

/**
 * Created by Andy on 3/14/2017.
 */

public class KeySingleCardViewModel extends KeyMeViewModel {
    private Drawable keyImageUrl;
    private String keyName;
    private String kiosksNearby;
    private ArrayList<String> historyItems;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    private int colorId;
    public ObservableInt position = new ObservableInt();

    public KeySingleCardViewModel(Drawable keyImageUrl, String keyName, int kiosksNearby, int colorId) {
        this.keyImageUrl = keyImageUrl;
        this.keyName = keyName;
        this.kiosksNearby = Integer.toString(kiosksNearby);
        this.colorId = colorId;
    }

    public View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    public void onImageClick() {

    }


    public Drawable getKeyImageUrl() {
        return keyImageUrl;
    }

    public void setKeyImageUrl(Drawable keyImageUrl) {
        this.keyImageUrl = keyImageUrl;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKiosksNearby() {
        return kiosksNearby;
    }

    public void setKiosksNearby(String kiosksNearby) {
        this.kiosksNearby = kiosksNearby;
    }

    public ArrayList<String> getHistoryItems() {
        return historyItems;
    }

    public void setHistoryItems(ArrayList<String> historyItems) {
        this.historyItems = historyItems;
    }
}
