package com.example.sumon.currencyconverter.util;

import io.reactivex.disposables.Disposable;

/**
 * Provides RxJava utility method.
 * @version 1.1
 * @since 1.1
 */
public class RxUtil {

    public static void dispose(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
