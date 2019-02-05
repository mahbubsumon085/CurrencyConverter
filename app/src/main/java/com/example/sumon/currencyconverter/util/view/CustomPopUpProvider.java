package com.example.sumon.currencyconverter.util.view;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.sumon.currencyconverter.R;

import javax.inject.Inject;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class CustomPopUpProvider extends PopupWindow {
    RecyclerView rvTaxAcountry;
    public RecyclerView getRvTaxAcountry(){
        return rvTaxAcountry;
    }
    public CustomPopUpProvider(Context mContext){
        super(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.custom_layout,null);
        rvTaxAcountry=customView.findViewById(R.id.rv_tax_country);
        rvTaxAcountry.setLayoutManager(new LinearLayoutManager(mContext,
                                LinearLayoutManager.VERTICAL, false));

        // Set an elevation value for popup window
        // Call requires API level 21// initialize a pop up window type
        //        PopupWindow popupWindow = new PopupWindow(this);
        //
        //        // the drop down list is a list view
        //        RecyclerView rvTax =new RecyclerView(this);
        //        rvTax.setLayoutManager(new LinearLayoutManager(this,
        //                LinearLayoutManager.VERTICAL, false));
        //        // set our adapter and pass our pop up window contents
        //                rvTax.setAdapter(mMainPresenter.getCurrencyAdapter());
        setFocusable(true);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setContentView(customView);
        if(Build.VERSION.SDK_INT>=21){
            setElevation(5.0f);
        }

    }
}
