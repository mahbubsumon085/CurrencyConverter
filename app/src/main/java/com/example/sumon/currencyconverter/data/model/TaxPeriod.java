package com.example.sumon.currencyconverter.data.model;

import android.databinding.Observable;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Holds information about the tax of particular country.
 *
 *  <p>
 *     Implements {@link Observable} to have impact on XML.
 *   <p/>
 *
 *  <p>
 *     Contains tax period.
 *   <p/>
 *
 *   <p>
 *     Map is used to store tax rate. It can by dynamic.
 *   <p/>
 *
 * @version 1.1
 * @since 1.1
 */
public class TaxPeriod implements Observable {

    @SerializedName("effective_from")
    String effective_from;
    @SerializedName("rates")
    Map<String,Double> rates;
    public String getEffectiveFrom() {
        return effective_from;
    }

    public Map<String,Double> getRates() {
        return rates;
    }

    public void setEffective_from(String effective_from) {
        this.effective_from = effective_from;
    }

    public void setRates(Map<String,Double> rates) {
        this.rates = rates;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}