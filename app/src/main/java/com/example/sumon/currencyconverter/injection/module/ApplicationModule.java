package com.example.sumon.currencyconverter.injection.module;

import android.app.Application;
import android.content.Context;

import com.example.sumon.currencyconverter.data.remote.APIInterface;
import com.example.sumon.currencyconverter.injection.ApplicationContext;
import com.example.sumon.currencyconverter.ui.tax.CurrencyAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 * @version 1.1
 * @since 1.1
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    APIInterface provideAPIInterface() {
        return APIInterface.Creator.newCurrencyService();
    }

    @Provides
    CurrencyAdapter provideCurrencyAdapter() {
        return CurrencyAdapter.getCurrencyAdapterInstance();
    }
}
