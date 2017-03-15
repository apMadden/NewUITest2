package me.key.android2.keychain.viewmodels;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.key.android2.KeyMeViewHolder;

/**
 * Created by Andy on 3/14/2017.
 */

public class KeyChainViewHolder extends KeyMeViewHolder {
    public KeyChainViewHolder(ViewDataBinding binding, int viewType) {
        super(binding, viewType);
    }

    public static KeyChainViewHolder create(LayoutInflater inflater, ViewGroup parent, int viewType) {
        ViewDataBinding mBinding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new KeyChainViewHolder(mBinding, viewType);
    }
}
