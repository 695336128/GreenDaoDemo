package com.zhang.greendaodemo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static com.zhang.greendaodemo.application.MyApplication.context;

/**
 * Created by zhang .
 * DATA: 2017/6/13 .
 * Description : GreenDao 帮助类
 */

public class DBMaster {

    // 是否加密
    public static final boolean ENCRYPTED = false;

    private static String DB_NAME = "student.db";
    private static DaoMaster.DevOpenHelper mHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private static volatile DBMaster instance = null;

    private DBMaster() {
        initDatabase();
    }

    public static DBMaster getInstance() {
        if (instance == null) {
            synchronized (DBMaster.class) {
                if (instance == null) {
                    instance = new DBMaster();
                }
            }
        }
        return instance;
    }


    /**
     * 初始化greenDao，这个操作建议在Application初始化的时候添加；
     */
    public static void initDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        getDaoMaster(context);
        getDaoSession(context);
        mDaoSession = mDaoMaster.newSession();
    }

    /**
     * 获取可读数据库
     */
    public static SQLiteDatabase getReadableDatabase() {
        if (null == mHelper) {
            getInstance();
        }
        return mHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     */
    public static SQLiteDatabase getWritableDatabase() {
        if (null == mHelper) {
            getInstance();
        }
        return mHelper.getWritableDatabase();
    }


    /**
     * 获取DaoMaster
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DBMaster.class) {
                if (null == mDaoMaster) {
                    MyOpenHelper helper = new MyOpenHelper(context, DB_NAME, null);
                    if (ENCRYPTED) {
                        mDaoMaster = new DaoMaster(helper.getEncryptedWritableDb(DB_NAME)); // 加密数据库
                    } else {
                        mDaoMaster = new DaoMaster(helper.getWritableDatabase());
                    }
                }
            }
        }
        return mDaoMaster;
    }

    /**
     * 获取DaoSession
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DBMaster.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }
}
