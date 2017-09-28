package com.zhang.greendaodemo.application;

import android.app.Application;
import android.content.Context;

import com.zhang.greendaodemo.dao.DBMaster;

/**
 * Created by zhang .
 * DATA: 2017/6/13 .
 * Description : MyApplication
 */

public class MyApplication extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
        DBMaster.initDatabase();
    }
}
