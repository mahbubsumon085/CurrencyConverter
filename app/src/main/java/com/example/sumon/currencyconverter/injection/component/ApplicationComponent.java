package com.example.sumon.currencyconverter.injection.component;

import android.app.Application;
import android.content.Context;

import com.example.sumon.currencyconverter.data.DataManager;
import com.example.sumon.currencyconverter.data.local.DatabaseHelper;
import com.example.sumon.currencyconverter.data.local.PreferencesHelper;
import com.example.sumon.currencyconverter.data.remote.APIInterface;
import com.example.sumon.currencyconverter.injection.ApplicationContext;
import com.example.sumon.currencyconverter.injection.module.ApplicationModule;
import com.example.sumon.currencyconverter.ui.tax.CurrencyAdapter;
import com.example.sumon.currencyconverter.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This component inject different dependencies across the application.
 * @version 1.1
 * @since 1.1
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    APIInterface aPIInterface();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();
    CurrencyAdapter currencyAdapter();
}
