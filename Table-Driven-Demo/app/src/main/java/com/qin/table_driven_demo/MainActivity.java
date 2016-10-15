package com.qin.table_driven_demo;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qin.table_driven_demo.business.BusinessDispense;
import com.qin.table_driven_demo.contants.Mode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusinessDispense dispense = BusinessDispense.getInstance();

        //调用注册方法
        Object[] params = {Mode.SYSTEM_REGISTER};//具体请求参数
        dispense.setParameters(Mode.SYSTEM, Mode.SYSTEM_REGISTER, params);
        dispense.dispense();

        //调用登录方法
        params = new Object[]{Mode.SYSTEM_LOGIN};//具体请求参数
        dispense.setParameters(Mode.SYSTEM, Mode.SYSTEM_LOGIN, params);
        dispense.dispense();

        //调用消息列表方法
        params = new Object[]{Mode.MINE_MESSAGE};//具体请求参数
        dispense.setParameters(Mode.MINE, Mode.MINE_MESSAGE, params);
        dispense.dispense();

        //调用消息置为已读方法
        params = new Object[]{Mode.MINE_MESSAGE_READ};//具体请求参数
        dispense.setParameters(Mode.MINE, Mode.MINE_MESSAGE_READ, params);
        dispense.dispense();

    }
}
