package me.key.android2;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


/**
 * Created by andrew.madden on 9/26/16.
 */
public abstract class KeyMeViewHolder extends RecyclerView.ViewHolder {
    public int viewType;
    public ViewDataBinding mBinding;
    public Object objData;
    public KeyMeViewModel viewModel;

    public KeyMeViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public KeyMeViewHolder(ViewDataBinding binding, int viewType) {
        super(binding.getRoot());
        this.viewType = viewType;
        this.mBinding = binding;
    }

    public KeyMeViewHolder(ViewDataBinding binding, int viewType, KeyMeViewModel viewModel) {
        super(binding.getRoot());
        this.viewType = viewType;
        this.mBinding = binding;
        this.viewModel = viewModel;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public void bindTo(Object obj) {
        this.objData = obj;
        mBinding.setVariable(me.key.android2.BR.data, obj);
        mBinding.executePendingBindings();
    }
}
