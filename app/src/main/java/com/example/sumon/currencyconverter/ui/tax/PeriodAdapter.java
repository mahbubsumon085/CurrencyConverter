package com.example.sumon.currencyconverter.ui.tax;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.example.sumon.currencyconverter.data.model.TaxPeriod;
import com.example.sumon.currencyconverter.databinding.PeriodItemBinding;
import com.example.sumon.currencyconverter.listener.TaxPeriodChangeListener;
import com.example.sumon.currencyconverter.ui.base.BaseAdapter;
import com.example.sumon.currencyconverter.ui.base.BaseViewHolder;

import java.util.ArrayList;

import javax.inject.Inject;

public class PeriodAdapter extends ArrayAdapter<TaxPeriod> implements SpinnerAdapter {
    protected ArrayList<TaxPeriod> taxPeriodItems;
    TaxPeriodChangeListener taxPeriodChangeListener;
    public void setTaxPeriodChangeListener(TaxPeriodChangeListener taxPeriodChangeListener) {
        this.taxPeriodChangeListener = taxPeriodChangeListener;
    }

    public PeriodAdapter(Context mContext, ArrayList<TaxPeriod> taxPeriodItems) {
        super(mContext, android.R.layout.simple_spinner_dropdown_item, taxPeriodItems);
        this.taxPeriodItems=taxPeriodItems;
    }

    public ArrayList<TaxPeriod> getTaxPeriodItems() {
        return taxPeriodItems;
    }

    public void setTaxPeriodItems(ArrayList<TaxPeriod> taxPeriodItems) {
        this.taxPeriodItems = taxPeriodItems;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(taxPeriodChangeListener!=null){
            taxPeriodChangeListener.onSelectTaxPeriod(taxPeriodItems.get(position),position);
        }
        return getView( position , convertView , parent );
    }


    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return taxPeriodItems.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PeriodItemBinding binding;
        if(convertView == null){
            binding= PeriodItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false);
        }else{
            binding = (PeriodItemBinding) convertView.getTag();
        }
        binding.tvPeriod.setTextColor(Color.parseColor("#000000"));
        BaseViewHolder holder=new BaseViewHolder(binding);
        Object obj = taxPeriodItems.get(position);
        holder.bind(obj);
        binding.getRoot().setTag(binding);
        return binding.getRoot();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


}
