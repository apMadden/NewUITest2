package me.key.android2.keychain.viewmodels;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.ArrayList;

import me.key.android2.KeyMeViewModel;
import me.key.android2.R;

/**
 * Created by Andy on 3/14/2017.
 */

public class KeyGroupCardViewModel extends KeyMeViewModel {

    private String keyGroupName;
    private String numberOfKeys;
    private ArrayList<KeySingleCardViewModel> keys;
    public final ObservableInt position = new ObservableInt();
    public final ObservableBoolean keyExpanded = new ObservableBoolean(false);

    public KeyGroupCardViewModel(String keyGroupName, ArrayList<KeySingleCardViewModel> keys) {
        this.keyGroupName = keyGroupName;
        this.keys = keys;
        this.numberOfKeys = Integer.toString(keys.size());
    }

    public KeySingleCardViewModel getSearchedKey() {
        return keys.get(position.get());
    }

    public void onThisClick() {

    }

    public void onButtonClick(View v) {
        if (keyExpanded.get()) {
            Log.i("hey", "onClick: 1");
            collapse(v.getRootView().findViewById(R.id.cv_keychain_single_key_temp));
            keyExpanded.set(false);
        } else {
            Log.i("hey", "onClick: 2");
            expand(v.getRootView().findViewById(R.id.cv_keychain_single_key_temp));
            keyExpanded.set(true);
        }
    }

    public static void expand(final View v) {
        v.setVisibility(View.VISIBLE);
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public String getKeyGroupName() {
        return keyGroupName;
    }

    public void setKeyGroupName(String keyGroupName) {
        this.keyGroupName = keyGroupName;
    }

    public String getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(String numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public ArrayList<KeySingleCardViewModel> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<KeySingleCardViewModel> keys) {
        this.keys = keys;
    }
}
