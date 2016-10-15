package com.qin.table_driven_demo.business.impl;

import android.util.Log;

import com.qin.table_driven_demo.business.BaseBusinessImpl;

/**
 * Description: 类说明
 * Created by Qin on 2016-10-15 15:39. Updated
 * Author: QinHan
 * Email: qinhan@uccc.cc
 * Version: V1.0
 */
public class SystemBusiness extends BaseBusinessImpl {

    public void register(Object[] params) {
        Log.i("DRIVEN", "SYSTEM" + params[0]);
    }

    public void login(Object[] params) {
        Log.i("DRIVEN", "SYSTEM" + params[0]);
    }
}
