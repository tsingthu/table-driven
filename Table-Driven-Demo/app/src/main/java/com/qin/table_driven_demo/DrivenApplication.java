package com.qin.table_driven_demo;

import android.app.Application;

/**
 * Description: 类说明
 * Created by Qin on 2016-10-15 15:25. Updated
 * Author: QinHan
 * Email: qinhan@uccc.cc
 * Version: V1.0
 */
public class DrivenApplication extends Application {
    private static DrivenApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static DrivenApplication getContext() {
        return application;
    }
}
