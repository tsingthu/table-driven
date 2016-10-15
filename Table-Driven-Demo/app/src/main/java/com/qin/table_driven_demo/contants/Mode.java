package com.qin.table_driven_demo.contants;

import android.util.Log;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 类说明
 * Created by Qin on 2016-10-15 15:25. Updated
 * Author: QinHan
 * Email: qinhan@uccc.cc
 * Version: V1.0
 */
public enum Mode {
    SYSTEM("system"), SYSTEM_REGISTER("system_register"), SYSTEM_LOGIN("system_login"),

    MINE("mine"), MINE_MESSAGE("mine_message"), MINE_MESSAGE_READ("mine_message_read");

    private String value;

    Mode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static final Map<String, Mode> map = toIndexes(Mode.values());

    public Mode getMode(String value) {
        return map.get(value);
    }

    static Map<String, Mode> toIndexes(Mode[] enums) {
        String curIdx = null;
        Map<String, Mode> map = new TreeMap<>();
        // 找到最大index，此值+1就是结果list的size
        for (Mode enm : enums) {
            curIdx = enm.getValue();
            // 索引不能为负
            if (curIdx == null) {
                Log.e("IndexEnum", String.format("枚举类%s的String索引不允许为空", enums.getClass().getComponentType().getName()));
                throw new RuntimeException(String.format("枚举类%s的String索引不允许为空", enums.getClass().getComponentType().getName()));
            }
            map.put(curIdx, enm);
        }
        return map;
    }
}
