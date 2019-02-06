package com.example.sumon.currencyconverter.ui.tax;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.sumon.currencyconverter.data.model.TaxItem;
import com.example.sumon.currencyconverter.databinding.ItemTaxByCountryBinding;
import com.example.sumon.currencyconverter.listener.TaxItemInputListener;
import com.example.sumon.currencyconverter.ui.base.BaseAdapter;
import com.example.sumon.currencyconverter.ui.base.BaseViewHolder;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * Adapter to show country in recycler view. It will also show
 * EditText field to enter amount to calculate tax.
 * @version 1.1
 * @since 1.1
 */

public class CurrencyAdapter extends BaseAdapter  {
    private TaxItemInputListener taxItemInputListener;
    protected ArrayList<TaxItem> taxItems;

    public void setTaxItemInputListener(TaxItemInputListener taxItemInputListener) {
        this.taxItemInputListener = taxItemInputListener;
    }

    public ArrayList<TaxItem> getTaxItems() {
        return taxItems;
    }

    public void setTaxItems(ArrayList<TaxItem> taxItems) {
        this.taxItems = taxItems;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemTaxByCountryBinding binding= ItemTaxByCountryBinding.inflate(
                layoutInflater, parent, false);
        return new CurrencyViewHolder(binding);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder,
                                 int position) {

        final Object obj = getObjForPosition(position);
        holder.bind(obj);
        final ItemTaxByCountryBinding dataBinding= (ItemTaxByCountryBinding) holder.getDataBinding();
        dataBinding.btCalculateTaxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(taxItemInputListener!=null && !dataBinding.etAmount.getText().toString().isEmpty()){
                    taxItemInputListener.onTaxItemInserted((TaxItem) obj,
                            Float.parseFloat(dataBinding.etAmount.getText().toString()));
                }
            }
        });

    }

    public CurrencyAdapter(ArrayList<TaxItem> taxItems) {
        this.taxItems = taxItems;
    }



    @Override
    protected Object getObjForPosition(int position) {
        return taxItems.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return taxItems.size();
    }


    /**
     * Provides object of this class for dependency injection
     */
    public static CurrencyAdapter getCurrencyAdapterInstance(){
        return new CurrencyAdapter(new ArrayList<TaxItem>());
    }

}
