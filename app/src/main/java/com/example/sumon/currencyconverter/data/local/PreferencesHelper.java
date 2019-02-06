package com.example.sumon.currencyconverter.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.sumon.currencyconverter.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Wrapper classes for {@link SharedPreferences}.
 * @version 1.1
 * @since 1.1
 */
@Singleton
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "currency_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

}
