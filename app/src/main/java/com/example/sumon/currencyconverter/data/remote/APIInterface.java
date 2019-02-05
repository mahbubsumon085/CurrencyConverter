package com.example.sumon.currencyconverter.data.remote;


import com.example.sumon.currencyconverter.data.model.CurrencyListAll;
import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.util.view.PeriodInfoDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIInterface {
    String ENDPOINT = "https://jsonvat.com/";
    @GET("/")
    Observable<CurrencyListAll> getListResources();

    /******** Helper class that sets up a new services *******/
    public class Creator {

        public static APIInterface newCurrencyService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(createGsonConverter())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                    //  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(APIInterface.class);
        }

        static Converter.Factory createGsonConverter() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(TaxPeriod.class, new PeriodInfoDeserializer());
            Gson gson = gsonBuilder.create();
            return GsonConverterFactory.create(gson);
        }
    }



}
