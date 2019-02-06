package com.example.sumon.currencyconverter.data.model;

import android.databinding.Observable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the full response of taxes.
 *  <p>
 *     Contains tax item.
 *   <p/>
 *
 * @version 1.1
 * @since 1.1
 */
public class CurrencyListAll {
    @SerializedName("details")
    String details;

    public List<TaxItem> getRates() {
        return rates;
    }

    @SerializedName("rates")
    public List<TaxItem> rates = new ArrayList();
}
