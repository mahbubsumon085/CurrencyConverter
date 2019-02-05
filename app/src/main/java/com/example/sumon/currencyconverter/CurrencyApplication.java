package com.example.sumon.currencyconverter;

import android.app.Application;
import android.content.Context;

import com.example.sumon.currencyconverter.injection.component.ApplicationComponent;
import com.example.sumon.currencyconverter.injection.component.DaggerApplicationComponent;
import com.example.sumon.currencyconverter.injection.module.ApplicationModule;

import timber.log.Timber;
public class CurrencyApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static CurrencyApplication get(Context context) {
        return (CurrencyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
