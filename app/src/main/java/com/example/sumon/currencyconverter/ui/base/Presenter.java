package com.example.sumon.currencyconverter.ui.base;

public interface Presenter <V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
