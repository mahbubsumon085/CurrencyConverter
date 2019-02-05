package com.example.sumon.currencyconverter.data.model;
import android.databinding.Observable;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
