package com.example.sumon.currencyconverter;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.sumon.currencyconverter.data.DataManager;
import com.example.sumon.currencyconverter.data.model.TaxItem;
import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.ui.base.MvpView;
import com.example.sumon.currencyconverter.ui.tax.CurrencyConverterActivity;
import com.example.sumon.currencyconverter.ui.tax.CurrencyConverterMvpView;
import com.example.sumon.currencyconverter.ui.tax.CurrencyConverterPresenter;
import com.example.sumon.currencyconverter.ui.tax.PeriodAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test business logic from activity {@link CurrencyConverterActivity}. Responsible
 *  for retrieving data from local and remote storage.
 *  <p>
 *     RxJava is used to retrieve data and update view.
 *   <p/>
 *
 *  <p>
 *     Also contains data to show and have impact on XML layout.
 *   <p/>
 * @version 1.1
 * @since 1.1
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyConverterPresenterTest {
    Map<String,Double> taxAmount;
    @Mock
    DataManager mDataManager ;
    PeriodAdapter mPeriodAdapter;
    @Mock
    ObservableField<TaxItem> selectedTaxtPeriod;
    @Mock
    CurrencyConverterMvpView view;

    @Mock
    Context mContext;
    //class to test
    private CurrencyConverterPresenter SUT;
    TaxPeriod taxPeriod=new TaxPeriod();
    TaxItem taxItem=new TaxItem();

    @Before
    public void setup() throws Exception {

        SUT = new CurrencyConverterPresenter(mDataManager);
        SUT.income=100;

        taxAmount=new HashMap<>();
        taxAmount.put("some key",5.00);
        taxPeriod.setRates(taxAmount);
        ArrayList<TaxPeriod> taxPeriods=new ArrayList<>();
        taxPeriods.add(taxPeriod);
        taxItem.setPeriods(taxPeriods);
        SUT.selectedTaxtPeriod=selectedTaxtPeriod;
        mPeriodAdapter=new PeriodAdapter(mContext, (ArrayList<TaxPeriod>) taxItem.getPeriods());
        SUT.setPeriodAdapter(mPeriodAdapter);


    }

    @Test
    public void calculateTax_positiveRate_returnedValidOutput() {

        SUT.calculateTax(5.00);
        assertEquals("You should pay to govt.", SUT.totalAmount.get(),
                "Your income= 100.0 and tax amount= 5.0");
    }

    @Test
    public void calculateTax_zeroRate_returnedNoTax() {

        SUT.calculateTax(0.00);
        assertEquals("You should not pay any tax", SUT.totalAmount.get(),
                "Congratulation! You live in a free country.");
    }

    @Test
    public void calculateTax_negativeRate_returnedValidOutput() {

        SUT.calculateTax(-5.00);
        assertEquals("Someone should have pay you", SUT.totalAmount.get(),
                "Negative tax amount. You should be proud of your country");
    }

    @Test
    public void populateTaxRateRadio_calledWithInitialValue_taxIsCalculated() {
        SUT = Mockito.spy(SUT);
        when(SUT.getMvpView()).thenReturn( view);
        SUT.populateTaxRateRadio(taxAmount);
        assertEquals("You should pay to govt.", SUT.totalAmount.get(),
                "Your income= 100.0 and tax amount= 5.0");
    }

    @Test
    public void updatePeriodSpinner_initialSelection_returnedValidOutput() {
        SUT = Mockito.spy(SUT);
        when(SUT.getMvpView()).thenReturn( view);
//        mPeriodAdapter = Mockito.spy(mPeriodAdapter);
  //      doNothing().when(mPeriodAdapter).notifyDataSetChanged();
        SUT.updatePeriodSpinner();
        assertEquals("You should pay to govt.", SUT.totalAmount.get(),
                "Your income= 100.0 and tax amount= 5.0");
      //  verify(SUT, times(1)).populateTaxRateRadio(taxAmount);
    }

}
