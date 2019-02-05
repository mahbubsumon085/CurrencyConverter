package com.example.sumon.currencyconverter.injection.component;

import com.example.sumon.currencyconverter.injection.ConfigPersistent;
import com.example.sumon.currencyconverter.injection.module.ActivityModule;

import dagger.Component;

/**
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}