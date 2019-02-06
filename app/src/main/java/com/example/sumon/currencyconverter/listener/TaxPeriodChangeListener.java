package com.example.sumon.currencyconverter.listener;

import com.example.sumon.currencyconverter.data.model.TaxPeriod;

/**
 * This interface is used to provide the callback to presenter
 *  if a tax period of a tax item is selected.
 * @version 1.1
 * @since 1.1
 */
public interface TaxPeriodChangeListener {

    /**
     * Will be called if user select a tax period.
     * @param taxPeriod holds information about tax period
     * @amount pos adapter item position if needed.
     */
    void onSelectTaxPeriod(TaxPeriod taxPeriod, int pos);
}
