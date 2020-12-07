package com.wanggh8.puremvvm.view;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wanggh8.puremvvm.BaseApplication;

/**
 * activity基类
 * @author wanggh8
 * @version V1.0
 * @date 2020/11/30
 */
public class BaseActivity extends AppCompatActivity {

    private ViewModelProvider mActivityProvider;
    private ViewModelProvider mApplicationProvider;

    // 当前活动名，调试使用
    public String TAG = getClass().getSimpleName();

    /**
     * 绑定 ViewModel
     * 设置观察 LiveData 对象
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 页面接受的参数方法
        initParam();
        // 页面数据初始化方法
        initData();
        // 页面事件监听的方法，一般用于ViewModel层转到View层的事件注册
        initViewObservable();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Lifecycle", "onStart mActivity ：" + getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Lifecycle", "onResume mActivity ：" + getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Lifecycle", "onPause mActivity ：" + getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Lifecycle", "onStop mActivity ：" + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // 框架中提供了 Application、Activity、Fragment 三个级别的作用域，
    // 通过不同作用域的 Provider 获得的 ViewModel 实例不是同一个，

    /**
     * 获取Activity作用域的ViewModel
     *
     * @param modelClass ViewModel实现类
     * @param <T> ViewModel类型
     * @return ViewModel子类
     */
    protected <T extends ViewModel> T getActivityScopeViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = getActivityViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    /**
     * 获取Application作用域的ViewModel
     *
     * @param modelClass ViewModel实现类
     * @param <T> ViewModel类型
     * @return ViewModel子类
     */
    protected <T extends ViewModel> T getApplicationScopeViewModel(@NonNull Class<T> modelClass) {
        if (mApplicationProvider == null) {
            mApplicationProvider = getAppViewModelProvider();
        }
        return mApplicationProvider.get(modelClass);
    }

    /**
     * 获取Application作用域的ViewModelProvider
     *
     * @return ViewModelProvider
     */
    protected ViewModelProvider getAppViewModelProvider() {
        return ((BaseApplication) getApplicationContext()).getAppViewModelProvider(this);
    }

    /**
     * 获取Activity作用域的ViewModelProvider
     *
     * @return ViewModelProvider
     */
    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity activity) {
        return new ViewModelProvider(activity, activity.getDefaultViewModelProviderFactory());
    }

    /**
     * 跳转页面
     *
     * @param toActivity 所跳转的目的Activity类
     */
    public void startActivity(Class<?> toActivity) {
        startActivity(new Intent(this, toActivity));
    }

    /**
     * 跳转页面
     *
     * @param toActivity 所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> toActivity, Bundle bundle) {
        Intent intent = new Intent(this, toActivity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 初始化页面参数 如布局方向
     */
    public void initParam() {

    }

    /**
     * 初始化数据
     */
    public void initData() {

    }

    /**
     * 页面事件监听, 事件注册
     */
    public void initViewObservable() {

    }


    /**
     * 判断是否debug模式
     *
     * @return boolean
     */
    public boolean isDebug() {
        return getApplicationContext().getApplicationInfo() != null &&
                (getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }


}
