package com.example.sumon.currencyconverter.ui.tax;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.sumon.currencyconverter.R;
import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.ui.base.BaseActivity;
import javax.inject.Inject;
import com.example.sumon.currencyconverter.databinding.ActivityCurrencyConverterBinding;
import com.example.sumon.currencyconverter.util.view.CustomPopUpProvider;
import java.util.ArrayList;

/**
 * Activity to show show tax rate by countries with different period and type.
 * It also facilitates user to enter amount and calculate tax on it.
 * @version 1.1
 * @since 1.1
 */
public class CurrencyConverterActivity extends BaseActivity implements CurrencyConverterMvpView
{
    @Inject
    CurrencyConverterPresenter mMainPresenter;
    CustomPopUpProvider popupWindow;
    ActivityCurrencyConverterBinding activityCurrencyConverterBinding;

    /**
     *{@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        activityCurrencyConverterBinding = DataBindingUtil.setContentView(this, R.layout.activity_currency_converter);
        mMainPresenter.attachView(this);
        mMainPresenter.loadCurrency();
        activityCurrencyConverterBinding.setPresenter(mMainPresenter);
        initview();
    }

    public void initview(){
        popupWindow=new CustomPopUpProvider(this);
        popupWindow.getRvTaxAcountry().setAdapter(mMainPresenter.getCurrencyAdapter());

    }

    public void popupWindowDogs(View view) {
        popupWindow.showAsDropDown(view, -5, 0);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void showPeriod(ArrayList<TaxPeriod> taxPeriodItems) {
        mMainPresenter.setPeriodAdapter(new PeriodAdapter(this,taxPeriodItems));
        activityCurrencyConverterBinding.spinnerPeriod.setAdapter(mMainPresenter.getPeriodAdapter());
        mMainPresenter.getPeriodAdapter().setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.d("Spinner","activityCurrencyConverterBinding.spinnerPeriod "+activityCurrencyConverterBinding.spinnerPeriod.getPrompt());
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void showCurrencyEmpty() {
        activityCurrencyConverterBinding.executePendingBindings();
        popupWindow.dismiss();
    }

    @Override
    public void showError() {

    }

    /**
     * Add radio button in radio group to show tax rate.
     * @param taxtType shows tax type
     * @param taxAmount tax rate
     * @param isChecked  radio button checked state. By default first element is checked.
     * @id  radio button is
     */
    @Override
    public void showTaxRate(String taxtType, double taxAmount, boolean isChecked, int id) {
        if(isChecked){
            activityCurrencyConverterBinding.radioTaxRate.removeAllViews();
        }
        activityCurrencyConverterBinding.radioTaxRate.setOnCheckedChangeListener(null);
        final RadioButton radioTaxParcentButton = new RadioButton(this);
        radioTaxParcentButton.setChecked(true);
        radioTaxParcentButton.setId(id);
        radioTaxParcentButton.setText(taxtType+" : "+taxAmount);
        radioTaxParcentButton.setTag(taxAmount);
        activityCurrencyConverterBinding.radioTaxRate.addView(radioTaxParcentButton,
                0);
        activityCurrencyConverterBinding.radioTaxRate.setOrientation(LinearLayout.VERTICAL);
        activityCurrencyConverterBinding.radioTaxRate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if(((RadioButton)radioGroup.findViewById(checkedId)).isChecked()){
                    mMainPresenter.calculateTax((Double) radioGroup.findViewById(checkedId).getTag());
                }
            }
        });
    }

}
