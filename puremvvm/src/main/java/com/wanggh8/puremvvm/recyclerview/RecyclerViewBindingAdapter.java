package com.wanggh8.puremvvm.recyclerview;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/12/7
 */
public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {"adapter", "autoScrollToTopWhenInsert", "autoScrollToBottomWhenInsert"}, requireAll = false)
    public static void bindList(RecyclerView recyclerView, BaseAdapter<BaseItem> adapter, List<BaseItem> list,
                                boolean autoScrollToTopWhenInsert, boolean autoScrollToBottomWhenInsert){

        if (recyclerView == null) {
            return;
        }

        if (adapter != null) {
            recyclerView.setAdapter(adapter);
        }

        if (recyclerView.getAdapter() == null) {
            return;
        }

        if (list != null) {
            adapter.setCollection(list);
        }

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                if (autoScrollToTopWhenInsert) {
                    recyclerView.scrollToPosition(0);
                } else if (autoScrollToBottomWhenInsert) {
                    recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount());
                }
            }
        });

    }
}
