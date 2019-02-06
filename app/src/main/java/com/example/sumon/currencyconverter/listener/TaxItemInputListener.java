package com.example.sumon.currencyconverter.listener;

import com.example.sumon.currencyconverter.data.model.TaxItem;

/**
 * This interface is used to provide the callback to presenter
 *  if Tax item with amount is selected.
 * @version 1.1
 * @since 1.1
 */
public interface TaxItemInputListener {

    /**
     * Will be called if user select a tax item
     * @param taxItem holds information about tax country and rate
     * @amount Entered tax amount by user.
     */
    public void onTaxItemInserted(TaxItem taxItem, double amount);
}
