package com.wanggh8.puremvvm.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.wanggh8.puremvvm.BaseApplication;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/11/30
 */
public class BaseFragment extends Fragment {

    // 所属Activity
    protected AppCompatActivity mActivity;
    // 所属Activity上下文
    protected Context mContext;
    // 当前Fragment文件名，调试使用
    public String TAG = getClass().getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 初始化除View外的逻辑
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // 方便调试，添加当前Fragment名
        Log.d("onCreate mFragment ：", getClass().getSimpleName());

    }

    /**
     * 每次创建、绘制该Fragment的View组件时回调该方法，Fragment将会显示该方法返回的View组件
     * 初始化静态View
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return null;
    }

    /**
     * 当Fragment所在的Activity被启动完成后回调该方法
     * 添加动态View
     * 访问父Activity的View层
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public Context getContext() {
        return mContext;
    }


    // 给当前BaseFragment用的
    protected ViewModelProvider getAppViewModelProvider() {
        return ((BaseApplication) mActivity.getApplicationContext()).getAppViewModelProvider(mActivity);
    }

    // 给所有的fragment提供的函数，可以顺利的拿到 ViewModel
    protected ViewModelProvider getFragmentViewModelProvider(Fragment fragment) {
        return new ViewModelProvider(fragment, fragment.getDefaultViewModelProviderFactory());
    }

    // 给所有的fragment提供的函数，可以顺利的拿到 ViewModel
    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity activity) {
        return new ViewModelProvider(activity, activity.getDefaultViewModelProviderFactory());
    }

    /**
     * 为了给所有的fragment，导航跳转fragment的
     * @return
     */
    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }

    public boolean isDebug() {
        return mActivity.getApplicationContext().getApplicationInfo() != null &&
                (mActivity.getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}
