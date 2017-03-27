package me.key.android2.keychain;

import java.util.ArrayList;

import me.key.android2.KeyMeViewModel;
import me.key.android2.keychain.viewmodels.KeyGroupCardViewModel;
import me.key.android2.keychain.viewmodels.KeySingleCardViewModel;
import me.key.android2.keychain.viewmodels.LoginCardViewModel;

/**
 * Created by Andy on 3/14/2017.
 */

public class KeyChainViewModel extends KeyMeViewModel {
    private KeyChainViewModelInterface keyChainViewModelInterface;
    private String kioskImageUrl;
    private LoginCardViewModel loginCardViewModel;
    private ArrayList<String> promoImageUrls;
    private ArrayList<KeySingleCardViewModel> keySingleCardViewModels;
    private ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels;

    public KeyChainViewModel(String kioskImageUrl, LoginCardViewModel loginCardViewModel, ArrayList<String> promoImageUrls, ArrayList<KeySingleCardViewModel> keySingleCardViewModels, ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels, KeyChainViewModelInterface keyChainViewModelInterface) {
        this.keyChainViewModelInterface = keyChainViewModelInterface;
        this.kioskImageUrl = kioskImageUrl;
        this.loginCardViewModel = loginCardViewModel;
        this.promoImageUrls = promoImageUrls;
        this.keySingleCardViewModels = keySingleCardViewModels;
        this.keyGroupCardViewModels = keyGroupCardViewModels;
    }

    public KeyChainViewModelInterface getKeyChainViewModelInterface() {
        return keyChainViewModelInterface;
    }

    public void setKeyChainViewModelInterface(KeyChainViewModelInterface keyChainViewModelInterface) {
        this.keyChainViewModelInterface = keyChainViewModelInterface;
    }


    public ArrayList<KeySingleCardViewModel> getKeySingleCardViewModels() {
        return keySingleCardViewModels;
    }

    public void setKeySingleCardViewModels(ArrayList<KeySingleCardViewModel> keySingleCardViewModels) {
        this.keySingleCardViewModels = keySingleCardViewModels;
    }

    public ArrayList<KeyGroupCardViewModel> getKeyGroupCardViewModels() {
        return keyGroupCardViewModels;
    }

    public void setKeyGroupCardViewModels(ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels) {
        this.keyGroupCardViewModels = keyGroupCardViewModels;
    }

    public ArrayList<String> getPromoImageUrls() {
        return promoImageUrls;
    }

    public void setPromoImageUrls(ArrayList<String> promoImageUrls) {
        this.promoImageUrls = promoImageUrls;
    }

    public LoginCardViewModel getLoginCardViewModel() {
        return loginCardViewModel;
    }

    public void setLoginCardViewModel(LoginCardViewModel loginCardViewModel) {
        this.loginCardViewModel = loginCardViewModel;
    }

    public String getKioskImageUrl() {
        return kioskImageUrl;
    }

    public void setKioskImageUrl(String kioskImageUrl) {
        this.kioskImageUrl = kioskImageUrl;
    }

}
