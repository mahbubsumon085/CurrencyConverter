package com.example.sumon.currencyconverter.data;

import com.example.sumon.currencyconverter.data.local.DatabaseHelper;
import com.example.sumon.currencyconverter.data.local.PreferencesHelper;
import com.example.sumon.currencyconverter.data.model.CurrencyListAll;
import com.example.sumon.currencyconverter.data.remote.APIInterface;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Act as common places for the data sources.
 *
 *  <p>
 *     DatabaseHelper for local database, PreferencesHelper for local storage
 *     and APIInterface for remote sources.
 *   <p/>
 *
 * @version 1.1
 * @since 1.1
 */
@Singleton
public class DataManager {

    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final APIInterface mApiInterface;

    /**
     * Constructor with dependencies.
     */
    @Inject
    public DataManager( PreferencesHelper preferencesHelper,
                       DatabaseHelper databaseHelper, APIInterface apiInterface) {
        mPreferencesHelper = preferencesHelper;
        mDatabaseHelper = databaseHelper;
        mApiInterface = apiInterface;
    }

    public Observable<CurrencyListAll> getCurrency() {
        return mApiInterface.getListResources();
    }


}
