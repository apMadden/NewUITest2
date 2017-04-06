package me.key.android2.keychain;

import android.view.View;

/**
 * Created by Andy on 3/14/2017.
 */

public interface KeyChainViewModelInterface {
    void handleLoginButtonPressed(View v);
    void expandButtonPressed(View v);
    void handleCardFlip(View v);
}
