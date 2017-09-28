package com.zhang.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhang.greendaodemo.bean.StudentMsBean;
import com.zhang.greendaodemo.dao.DBMaster;
import com.zhang.greendaodemo.dao.StudentMsBeanDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private StudentMsBeanDao studentMsBeanDao;

    private Button insert;

    private Button delete_by_key;

    private Button delete_all;

    private Button updata;

    private Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        studentMsBeanDao = DBMaster.getDaoSession(getApplicationContext())
                .getStudentMsBeanDao();
    }

    /**
     * 插入数据
     */
    private void insert() {

        StudentMsBean studentMsBean = new StudentMsBean();
        studentMsBean.setName("莉莉丝");
        studentMsBean.setStudentNum("10010");
        studentMsBean.setNum(110);
        studentMsBeanDao.insert(studentMsBean);
//        studentMsBeanDao.insertOrReplace(studentMsBean);
//        studentMsBeanDao.save(studentMsBean);

        studentMsBean = new StudentMsBean();
        studentMsBean.setName("卫子夫");
        studentMsBean.setStudentNum("10011");
        studentMsBean.setNum(110);
        studentMsBeanDao.save(studentMsBean); // save()类似 {@link
                                              // #insertOrReplace(Object)}
    }

    /**
     * 插入数据集合
     */
    private void insertList(List<StudentMsBean> students){
        if(students == null || students.isEmpty()){
            return;
        }
        studentMsBeanDao.insertInTx(students);
//        studentMsBeanDao.insertOrReplaceInTx(students);
//        studentMsBeanDao.saveInTx(students);
//        studentMsBeanDao.saveInTx(student1,student2,student3);
    }


    /**
     * 删除数据
     */
    private void delete() {

        // 删除某个数据
        StudentMsBean studentMsBean = studentMsBeanDao.queryBuilder()
                .where(StudentMsBeanDao.Properties.Name.eq("卫子夫"))
                .build()
                .unique();// 执行查询并返回唯一结果或null。
        studentMsBeanDao.delete(studentMsBean);

        // // 根据主键删除数据
        // studentMsBeanDao.deleteByKey((long) 1);

    }

    private void deleteAll() {
        // 删除所有数据
        studentMsBeanDao.deleteAll();
    }

    // 改
    private void update() {
        StudentMsBean studentMsBean = studentMsBeanDao.queryBuilder().where(StudentMsBeanDao.Properties.Name.eq("莉莉丝"))
                .build().unique();
        studentMsBean.setStudentNum("10000");
        studentMsBeanDao.update(studentMsBean);
    }

    // 查
    private void load() {
        // 查询全部数据
        List<StudentMsBean> list = studentMsBeanDao.loadAll();
        for (int i = 0; i < list.size(); i++) {
            println(list.get(i));
        }

        // 查询一条数据
        StudentMsBean studentMsBean = studentMsBeanDao.queryBuilder()
                .where(StudentMsBeanDao.Properties.Name.eq("卫子夫"))
                .build()
                .unique();
        println(studentMsBean);
    }

    private void println(StudentMsBean studentMsBean) {
        if (studentMsBean != null) {
            System.out.println(studentMsBean.getId());
            System.out.println(studentMsBean.getName());
            System.out.println(studentMsBean.getStudentNum());
            System.out.println(studentMsBean.getNum());
        } else {
            System.out.println("查询为null");
        }

    }

    private void initView() {
        insert = (Button) findViewById(R.id.insert);
        delete_by_key = (Button) findViewById(R.id.delete_by_key);
        delete_all = (Button) findViewById(R.id.delete_all);
        updata = (Button) findViewById(R.id.updata);
        load = (Button) findViewById(R.id.load);

        insert.setOnClickListener(this);
        delete_by_key.setOnClickListener(this);
        delete_all.setOnClickListener(this);
        updata.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.insert:
            insert();
            break;
        case R.id.delete_by_key:
            delete();
            break;
        case R.id.delete_all:
            deleteAll();
            break;
        case R.id.updata:
            update();
            break;
        case R.id.load:
            load();
            break;
        }
    }
}
