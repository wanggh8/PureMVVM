package com.wanggh8.puremvvm.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/12/7
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public BaseViewHolder(@NonNull View itemView, ViewDataBinding binding) {
        super(itemView);
        this.binding = binding;
    }
}
