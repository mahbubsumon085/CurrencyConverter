package com.example.sumon.currencyconverter.injection.component;

import com.example.sumon.currencyconverter.injection.PerActivity;
import com.example.sumon.currencyconverter.injection.module.ActivityModule;
import com.example.sumon.currencyconverter.ui.tax.CurrencyConverterActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application.
 * @version 1.1
 * @since 1.1
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(CurrencyConverterActivity mainActivity);

}
