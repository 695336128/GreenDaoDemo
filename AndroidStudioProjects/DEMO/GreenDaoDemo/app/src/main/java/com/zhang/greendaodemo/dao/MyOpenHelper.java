package com.zhang.greendaodemo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zhang . DATA: 2017/9/28 . Description :
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        // 操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db, StudentMsBeanDao.class);
    }
}
