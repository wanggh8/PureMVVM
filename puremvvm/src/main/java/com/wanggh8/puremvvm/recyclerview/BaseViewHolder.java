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
public abstract class BaseViewHolder<T extends BaseItem> extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public BaseViewHolder(@NonNull ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public BaseViewHolder(@NonNull View itemView, ViewDataBinding binding) {
        super(itemView);
        this.binding = binding;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }

    /**
     * 绑定数据的抽象方法
     *
     * @param binding ViewDataBinding
     * @param position 当前数据位置
     * @param t 数据对象
     */
    public abstract void onBind(ViewDataBinding binding, T t, int position);
}


