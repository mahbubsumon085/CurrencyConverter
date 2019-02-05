package com.example.sumon.currencyconverter.ui.tax;


import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sumon.currencyconverter.data.DataManager;
import com.example.sumon.currencyconverter.data.model.CurrencyListAll;
import com.example.sumon.currencyconverter.data.model.TaxItem;
import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.injection.ConfigPersistent;
import com.example.sumon.currencyconverter.listener.TaxItemInputListener;
import com.example.sumon.currencyconverter.listener.TaxPeriodChangeListener;
import com.example.sumon.currencyconverter.ui.base.BasePresenter;
import com.example.sumon.currencyconverter.util.RxUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@ConfigPersistent
public class CurrencyConverterPresenter extends BasePresenter<CurrencyConverterMvpView> implements
        TaxItemInputListener ,TaxPeriodChangeListener {
    private Disposable mDisposable;
    private final DataManager mDataManager;
    public ObservableField<String> totalAmount = new ObservableField<>();
    TaxPeriod taxPeriod;
    public ObservableField<String> selctCountryWithAmount = new ObservableField<>("Select tax amount for country");

    public ObservableField<TaxItem> selectedTaxtPeriod = new ObservableField<>();
    double income;
   // @Inject
    PeriodAdapter periodAdapter;

    public void setPeriodAdapter(PeriodAdapter periodAdapter) {
        this.periodAdapter = periodAdapter;
        this.periodAdapter.setTaxPeriodChangeListener(this);
    }

    public PeriodAdapter getPeriodAdapter() {
        return periodAdapter;
    }

    @Inject
    CurrencyAdapter currencyAdapter;

    public CurrencyAdapter getCurrencyAdapter() {
        return currencyAdapter;
    }

    @Inject
    public CurrencyConverterPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(CurrencyConverterMvpView mvpView) {
        super.attachView(mvpView);
    }


    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void loadCurrency() {
        currencyAdapter.setTaxItemInputListener(this);
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        mDataManager.getCurrency()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CurrencyListAll>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull CurrencyListAll currencyList) {
                        if (currencyList==null) {
                            getMvpView().showCurrencyEmpty();
                        } else {
                            currencyAdapter.setTaxItems((ArrayList<TaxItem>) currencyList.getRates());
                            currencyAdapter.notifyDataSetChanged();
                            getMvpView().showPeriod((ArrayList<TaxPeriod>) currencyList.getRates().get(0).getPeriods());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getMvpView().showError();
                        Log.d("CurrencyCon", "error "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("CurrencyCon", " ");

                    }
                });

    }

    @Override
    public void onTaxItemInserted(TaxItem taxItem, double amount) {
        income=amount;
        totalAmount.set("Total Amount "+amount);
        selctCountryWithAmount.set(taxItem.getName()+" : "+amount);
        selectedTaxtPeriod.set(taxItem);
        updatePeriodSpinner();
        synchronized(this){
            this.notify();
        }
        getMvpView().showCurrencyEmpty();


    }

    public void updatePeriodSpinner(){
        periodAdapter.setTaxPeriodItems((ArrayList<TaxPeriod>) selectedTaxtPeriod.get().getPeriods());
        periodAdapter.notifyDataSetChanged();
        // Show initial
        this.taxPeriod=selectedTaxtPeriod.get().getPeriods().get(0);
        populateTaxRateRadio(selectedTaxtPeriod.get().getPeriods().get(0).getRates());

    }

    public void populateTaxRateRadio(Map<String,Double> taxAmount){
        boolean isFirst=true;
        int i=0;
        for ( String key :taxAmount.keySet()) {
            Log.d("populateTax","key "+key);
            i++;
            double taxPercent= 0;
            taxPercent = taxAmount.get(key);
            if(getMvpView()!=null){
                getMvpView().showTaxRate(key, taxPercent, isFirst,i+1 );
                if(isFirst){
                    calculateTax(taxPercent);

                }
                isFirst=false;

            }
        }

    }

    @Override
    public void onSelectTaxPeriod(TaxPeriod taxPeriod, int pos) {
        populateTaxRateRadio(taxPeriod.getRates());
        this.taxPeriod=taxPeriod;
    }

    public void calculateTax(double tax ){
        Log.d("taxtax","tax  =  "+tax);
        if(tax>0){
            double taxAmount = income * tax;
            taxAmount/=100;
            totalAmount.set("Your income= "+income+" and tax amount= "+taxAmount);

        }
        else if(tax==0){
            totalAmount.set("Congratulation! You live in a free country.");
        }
        else{
            totalAmount.set("Negative tax amount. You should be proud of your country");
        }
    }
}
