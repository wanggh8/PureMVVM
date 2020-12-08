package com.wanggh8.puremvvm.recyclerview;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/12/7
 */
public class BaseItem {

    /**
     * item类别
     *
     * RecyclerView多布局使用
     * 使用时，返回item布局用于区分
     * 例如:
     * return R.layout.item_fruit;
     *
     * @return 布局id，默认为0
     */
    public int getItemType() {
        return 0;
    }
}
