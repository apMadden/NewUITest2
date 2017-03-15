package me.key.android2.keychain.viewmodels;

import android.databinding.ObservableField;
import android.view.View;

import me.key.android2.KeyMeViewModel;
import me.key.android2.keychain.KeyChainViewModel;
import me.key.android2.keychain.KeyChainViewModelInterface;

/**
 * Created by Andy on 3/14/2017.
 */

public class LoginCardViewModel extends KeyMeViewModel {
    public final ObservableField<String> emailAddress = new ObservableField<>("");
    public final ObservableField<String> password = new ObservableField<>("");
    private String promoText;

    public KeyChainViewModelInterface getKeyChainViewModelInterface() {
        return keyChainViewModelInterface;
    }

    public void setKeyChainViewModelInterface(KeyChainViewModelInterface keyChainViewModelInterface) {
        this.keyChainViewModelInterface = keyChainViewModelInterface;
    }

    private KeyChainViewModelInterface keyChainViewModelInterface;


    public LoginCardViewModel(String promoText, KeyChainViewModelInterface keyChainViewModelInterface) {
        this.promoText = promoText;
        this.emailAddress.set("");
        this.password.set("");
        this.keyChainViewModelInterface = keyChainViewModelInterface;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public void loginPressed(View v) {

    }
    public void createAccountPressed(View v) {

    }

    public void googleSignInPressed(View v) {

    }

    public void facebookLoginPressed(View v) {

    }
}
