package com.qin.table_driven_demo.business.impl;

import android.util.Log;

import com.qin.table_driven_demo.business.BaseBusinessImpl;

/**
 * Description: 类说明
 * Created by Qin on 2016-10-15 15:42. Updated
 * Author: QinHan
 * Email: qinhan@uccc.cc
 * Version: V1.0
 */
public class MineBusiness extends BaseBusinessImpl {

    public void mineMessages(Object[] params) {
        Log.i("DRIVEN", "MINE" + params[0]);
    }

    public void mineMessageRead(Object[] params) {
        Log.i("DRIVEN", "MINE" + params[0]);
    }
}
