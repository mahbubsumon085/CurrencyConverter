package com.example.sumon.currencyconverter.listener;

import com.example.sumon.currencyconverter.data.model.TaxPeriod;

public interface TaxPeriodChangeListener {
    void onSelectTaxPeriod(TaxPeriod taxPeriod, int pos);
}
