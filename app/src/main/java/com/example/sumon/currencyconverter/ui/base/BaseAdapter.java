package com.example.sumon.currencyconverter.ui.base;

import android.support.v7.widget.RecyclerView;

/**
 * Abstract BaseAdapter that every other Adapter in this application must implement.
 * @version 1.1
 * @since 1.1
 */
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