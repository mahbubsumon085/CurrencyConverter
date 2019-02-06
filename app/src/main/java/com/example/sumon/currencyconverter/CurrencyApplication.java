package com.example.sumon.currencyconverter;

import android.app.Application;
import android.content.Context;
import com.example.sumon.currencyconverter.injection.component.ApplicationComponent;
import com.example.sumon.currencyconverter.injection.component.DaggerApplicationComponent;
import com.example.sumon.currencyconverter.injection.module.ApplicationModule;
import timber.log.Timber;

/**
 * Application classe is the starting point of the App.
 * Configures all the instances that will be used all over the
 *  App.
 * @version 1.1
 * @since 1.1
 */
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

    /**
     * Initializes Dagger component.
     */
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
