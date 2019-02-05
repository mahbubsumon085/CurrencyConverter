package com.example.sumon.currencyconverter.ui.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sumon.currencyconverter.BR;
public class BaseViewHolder extends RecyclerView.ViewHolder{
    protected final ViewDataBinding binding;

    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.item, obj);
        Log.d("executePendin"," executePendin  "+obj.toString());
        binding.executePendingBindings();
    }

    public ViewDataBinding getDataBinding(){
        return binding;
    }
}

