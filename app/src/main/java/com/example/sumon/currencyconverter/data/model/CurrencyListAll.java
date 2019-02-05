package com.example.sumon.currencyconverter.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListAll {
    @SerializedName("details")
    String details;

    public List<TaxItem> getRates() {
        return rates;
    }

    @SerializedName("rates")
    public List<TaxItem> rates = new ArrayList();
}
