package com.wanggh8.puremvvm;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author wanggh8
 * @version V1.0
 * @date 2020/11/30
 */
public class BaseApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;
    private ViewModelProvider.Factory mFactory;


    @Override
    public void onCreate() {
        super.onCreate();

        mAppViewModelStore = new ViewModelStore();

        initLog();

    }

    /**
     * 初始化日志框架
     *
     * Logger.d("debug");
     * Logger.e("error");
     * Logger.w("warning");
     * Logger.v("verbose");
     * Logger.i("information");
     * Logger.wtf("What a Terrible Failure");
     * Logger.json(JSON_CONTENT);
     * Logger.xml(XML_CONTENT);
     * Logger.d(MAP);
     * Logger.d(SET);
     * Logger.d(LIST);
     * Logger.d(ARRAY);
     */
    private void initLog() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public ViewModelProvider getAppViewModelProvider(Activity activity) {
        return new ViewModelProvider((BaseApplication) activity.getApplicationContext(),
                ((BaseApplication) activity.getApplicationContext()).getAppFactory(activity));
    }

    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return mFactory;
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }

    private Activity checkActivity(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
        }
        return activity;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }
}
