package com.example.sumon.currencyconverter.data.model;

import android.databinding.Observable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds information about the tax of different country.
 *  <p>
 *     Implements {@link Observable} to have impact on XML.
 *   <p/>
 * @version 1.1
 * @since 1.1
 */
public class TaxItem implements Observable{
    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }

    @SerializedName("code")
    String code;
    @SerializedName("country_code")
    String countryCode;

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPeriods(List<TaxPeriod> periods) {
        this.periods = periods;
    }

    @SerializedName("periods")

    public List<TaxPeriod> periods = new ArrayList();

    public List<TaxPeriod> getPeriods() {
        return periods;
    }

    @Override

    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }



}
