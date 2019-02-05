package com.example.sumon.currencyconverter.ui.base;

import android.support.v7.widget.RecyclerView;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    @Override
    public void onBindViewHolder(BaseViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }
    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);
    ////

}