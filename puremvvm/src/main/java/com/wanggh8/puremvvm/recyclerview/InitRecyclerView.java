package com.wanggh8.puremvvm.recyclerview;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/12/7
 */
public class InitRecyclerView {

    public static void initLinearLayoutVERTICAL(Context context, RecyclerView recyclerView){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public static void initLinearLayoutHorizontal(Context context,RecyclerView recyclerView){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public static void initStaggered(Context context,RecyclerView recyclerView){
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sgm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }




}
