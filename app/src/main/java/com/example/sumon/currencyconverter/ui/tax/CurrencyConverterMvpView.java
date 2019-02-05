package com.example.sumon.currencyconverter.ui.tax;

import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.ui.base.MvpView;

import java.util.ArrayList;

public interface CurrencyConverterMvpView extends MvpView{
    void showPeriod(ArrayList<TaxPeriod> taxPeriodItems);

    void showCurrencyEmpty();

    void showError();

    void showTaxRate(String taxtType, double taxAmount, boolean isChecked, int id);

}
