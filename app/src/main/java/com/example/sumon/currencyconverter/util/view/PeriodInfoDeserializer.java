package com.example.sumon.currencyconverter.util.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PeriodInfoDeserializer implements JsonDeserializer<TaxPeriod> {

    private static final String KEY_EFFECTIVE_FROM = "effective_from";
    private static final String KEY_RATES = "rates";

    @Override
    public TaxPeriod deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        // Read simple String values.
        final String effectiveFrom = jsonObject.get(KEY_EFFECTIVE_FROM).getAsString();
        // Read the dynamic parameters object.
        final Map<String, Double> rates = readParametersMap(jsonObject);


        TaxPeriod result = new TaxPeriod();
        result.setEffective_from(effectiveFrom);
        result.setRates(rates);
        return result;
    }

    @Nullable
    private Map<String, Double> readParametersMap(@NonNull final JsonObject jsonObject) {
        final JsonElement paramsElement = jsonObject.get(KEY_RATES);
        if (paramsElement == null) {
            // value not present at all, just return null
            return null;
        }

        final JsonObject parametersObject = paramsElement.getAsJsonObject();
        final Map<String, Double> parameters = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : parametersObject.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue().getAsDouble();
            parameters.put(key, value);
        }
        return parameters;
    }
}
