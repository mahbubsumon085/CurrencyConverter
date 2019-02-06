package com.example.sumon.currencyconverter.ui.base;

/**
 * This interface is used to ensures that every presenter should invoked attach and
 * detach view from activity.
 * @version 1.1
 * @since 1.1
 */
public interface Presenter <V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
