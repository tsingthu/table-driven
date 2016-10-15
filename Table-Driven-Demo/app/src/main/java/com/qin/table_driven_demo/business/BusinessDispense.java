package com.qin.table_driven_demo.business;

import com.qin.table_driven_demo.DrivenApplication;
import com.qin.table_driven_demo.contants.Mode;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;

/**
 * Description: 类说明
 * Created by Qin on 2016-10-15 15:21. Updated
 * Author: QinHan
 * Email: qinhan@uccc.cc
 * Version: V1.0
 */
public class BusinessDispense {
    static Properties properties;
    Mode moduleMode, methodMode;
    Object params;

    private static HashMap<String, BaseBusiness> moduleClasses;
    private static HashMap<String, Method> methodClasses;

    private static final String[] sClassPrefixList = {
            "com.qin.table_driven_demo.business.impl."
    };

    private BusinessDispense() {

    }

    private static class BusinessDispenseHolder {
        private static final BusinessDispense INSTANCE = new BusinessDispense();
    }

    public static BusinessDispense getInstance() {
        if (properties == null) {
            try {
                properties = new Properties();
                InputStream open = DrivenApplication.getContext().getAssets().open("business.properties");
                InputStreamReader inputReader = new InputStreamReader(open);
                properties.load(inputReader);
                inputReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                properties = null;
            }
        }
        if (moduleClasses == null) {
            moduleClasses = new HashMap<>();
        }
        if (methodClasses == null) {
            methodClasses = new HashMap<>();
        }
        return BusinessDispenseHolder.INSTANCE;
    }

    public void setParameters(Mode moduleMode, Mode methodMode, Object params) {
        this.moduleMode = moduleMode;
        this.methodMode = methodMode;
        this.params = params;
    }

    public void dispense() {
        if (moduleMode != null && methodMode != null) {
            if (properties != null && properties.containsKey(methodMode.getValue())) {

                try {
                    BaseBusiness business;
                    Method method;
                    if (!moduleClasses.containsKey(moduleMode.getValue())) {
                        String className = properties.getProperty(moduleMode.getValue());
                        Class<?> businessClazz = null;
                        for (String prefix : sClassPrefixList) {
                            try {
                                businessClazz = Class.forName(prefix + className);
                                break;
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        if (businessClazz != null) {
                            Constructor<?> constructor = businessClazz.getConstructor();
                            business = (BaseBusiness) constructor.newInstance();
                            moduleClasses.put(moduleMode.getValue(), business);
                        }
                    }
                    business = moduleClasses.get(moduleMode.getValue());
                    business.initializeParameters();

                    if (!methodClasses.containsKey(methodMode.getValue())) {
                        Class<? extends BaseBusiness> methodClazz = business.getClass();
                        method = methodClazz.getDeclaredMethod(properties.getProperty(methodMode.getValue()), Object[].class);
                        methodClasses.put(methodMode.getValue(), method);
                    }
                    method = methodClasses.get(methodMode.getValue());
                    method.invoke(business, params);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
