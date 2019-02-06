package com.example.sumon.currencyconverter.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * A qualifier annotation for same type of ActivityContext object dependencies.
 * @version 1.1
 * @since 1.1
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
