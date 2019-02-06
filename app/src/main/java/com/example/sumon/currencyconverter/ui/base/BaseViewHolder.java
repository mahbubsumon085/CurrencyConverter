package com.example.sumon.currencyconverter.ui.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.sumon.currencyconverter.BR;

/**
 * Base BaseViewHolder for recyclerview adapter. Common works for
 *  all viewholder can be handle from this class. All viewholder must
 *  extend this class.
 * @version 1.1
 * @since 1.1
 */
public class BaseViewHolder extends RecyclerView.ViewHolder{
    protected final ViewDataBinding binding;

    /**
     * Constructor ensures data binding is being  used for adapter.
     * @param binding data binding for item view.
     */
    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Will be called from {@link RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int)}
     * @param obj object to show data in item view
     */
    public void bind(Object obj) {
        binding.setVariable(BR.item, obj);
        binding.executePendingBindings();
    }

    public ViewDataBinding getDataBinding(){
        return binding;
    }
}

