package com.example.sumon.currencyconverter.ui.tax;

import android.databinding.ViewDataBinding;

import com.example.sumon.currencyconverter.databinding.ItemTaxByCountryBinding;
import com.example.sumon.currencyconverter.ui.base.BaseViewHolder;
import com.example.sumon.currencyconverter.BR;

public class CurrencyViewHolder extends BaseViewHolder {
    public CurrencyViewHolder(ViewDataBinding binding) {
        super(binding);
    }

    @Override
    public void bind(Object obj) {
        ((ItemTaxByCountryBinding) binding).etAmount.setText("");
        binding.setVariable(BR.item, obj);
        binding.executePendingBindings();
    }

}
