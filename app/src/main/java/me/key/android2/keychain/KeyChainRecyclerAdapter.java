package me.key.android2.keychain;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.key.android2.KeyMeViewModel;
import me.key.android2.R;
import me.key.android2.keychain.viewmodels.FindKioskCardViewModel;
import me.key.android2.keychain.viewmodels.KeyChainViewHolder;
import me.key.android2.keychain.viewmodels.KeyGroupCardViewModel;
import me.key.android2.keychain.viewmodels.KeySingleCardViewModel;
import me.key.android2.keychain.viewmodels.LoginCardViewModel;

/**
 * Created by Andy on 3/14/2017.
 */

public class KeyChainRecyclerAdapter extends RecyclerView.Adapter<KeyChainViewHolder> {
    public static final String TAG = "KEYCHAINRECYCLERADAPTER";
    private ArrayList<KeySingleCardViewModel> keySingleCardViewModels;
    private ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels;
    private ArrayList<KeyMeViewModel> keyCardModels;
    private ArrayList<String> promoImageUrls;
    private LoginCardViewModel loginCardViewModel;
    private String kioskImageUrl;
    private boolean showLoginCard;
    private int numberOfKeyGroups;
    private int offset;

    public KeyChainRecyclerAdapter(String kioskImageUrl, LoginCardViewModel loginCardViewModel, ArrayList<String> promoImageUrls, ArrayList<KeySingleCardViewModel> keySingleCardViewModels, ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels) {
        this.kioskImageUrl = kioskImageUrl;
        this.loginCardViewModel = loginCardViewModel;
        this.showLoginCard = (loginCardViewModel.getKeyChainViewModelInterface() != null);
        this.promoImageUrls = promoImageUrls;
        this.keyCardModels = new ArrayList<>();
        this.keySingleCardViewModels =  new ArrayList<>(keySingleCardViewModels);
        this.keyGroupCardViewModels = new ArrayList<>(keyGroupCardViewModels);
        this.numberOfKeyGroups = keyGroupCardViewModels.size();
        this.keyCardModels.addAll(keyGroupCardViewModels);
        this.keyCardModels.addAll(keySingleCardViewModels);
        this.offset = (showLoginCard ? 4 : 3);
    }
    /*
    public void destroy() {
        promoImageUrls.clear();
        keySingleCardViewModels.clear();
        keyGroupCardViewModels.clear();
    }

    @Override
    public void quantityChanged(int listPosition) {
        notifyItemChanged(listPosition + 2);
    }

    @Override
    public void removeTransaction(int listPosition) {
        if (transactionViewModels.size() == 1) {
            callback.showEmptyCartDialog();
        } else {
            transactionViewModels.remove(listPosition);
            notifyItemChanged(totalPosition);
            notifyItemRemoved(listPosition);
            notifyItemRangeChanged(listPosition, getItemCount());
        }
    }*/

    @Override
    public int getItemCount() {
        return keySingleCardViewModels.size() + keyGroupCardViewModels.size() + 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return R.layout.card_find_kiosk;
        } else if (position == 1) {
            return R.layout.card_scan_a_new_key;
        } else if (position == 2) {/*
            return (showLoginCard ? R.layout.card_login : R.layout.card_promo);
        } else if (position == 3 && showLoginCard) {*/
            return R.layout.card_login;
        } else if (position == 3) { //(keyCardModels.get(position-3).getClass() == KeyGroupCardViewModel.class){
            return R.layout.card_key_group;
        } else {
            return R.layout.card_key_single;
        }
    }

    @Override
    public KeyChainViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == R.layout.card_key_single) {
            //final com.ramotion.foldingcell.FoldingCell fc = (com.ramotion.foldingcell.FoldingCell) viewGroup;
        }
        return KeyChainViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, viewType);
    }

    @Override
    public void onBindViewHolder(KeyChainViewHolder holder, int position) {
        final int holderPosition = holder.getAdapterPosition();
        if (holder.viewType == R.layout.card_find_kiosk) {
            holder.bindTo(new FindKioskCardViewModel(kioskImageUrl));
        } else if (holder.viewType == R.layout.card_login) {
            holder.bindTo(loginCardViewModel);
        } else if (holder.viewType == R.layout.card_promo) {
            holder.bindTo(promoImageUrls);
        } else if (holder.viewType == R.layout.card_scan_a_new_key) {
            holder.bindTo(promoImageUrls);
        } else if (holder.viewType == R.layout.card_key_group) {
            ((KeyGroupCardViewModel)keyCardModels.get(holderPosition - 3)).position.set(holderPosition);
            holder.bindTo(keyCardModels.get(holderPosition - 3));
        } else {
            ((KeySingleCardViewModel)keyCardModels.get(holderPosition - 3)).position.set(holderPosition);
            holder.bindTo(keyCardModels.get(holderPosition - 3));
        }
    }
}
