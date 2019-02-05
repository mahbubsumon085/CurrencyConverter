package com.example.sumon.currencyconverter.listener;

import com.example.sumon.currencyconverter.data.model.TaxItem;

public interface TaxItemInputListener {
    public void onTaxItemInserted(TaxItem taxItem, double amount);
}
