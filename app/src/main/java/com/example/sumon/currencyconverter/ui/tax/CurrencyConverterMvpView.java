package com.example.sumon.currencyconverter.ui.tax;

import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Interface to get callback from presenter to activity.
 * @version 1.1
 * @since 1.1
 */
public interface CurrencyConverterMvpView extends MvpView{

    /**
     * Will be triggered to show period in spinner.
     * @param taxPeriodItems period item
     */
    void showPeriod(ArrayList<TaxPeriod> taxPeriodItems);

    /**
     *  Will be triggered if no currency found.
     */
    void showCurrencyEmpty();

    /**
     *  Will be triggered if error occured.
     */
    void showError();

    /**
     *  Will be triggered to show tax rate
     * @param taxtType shows tax type
     * @param taxAmount tax rate
     * @param isChecked  radio button checked state. By default first element is checked.
     * @id  radio button is
     */
    void showTaxRate(String taxtType, double taxAmount, boolean isChecked, int id);

}
