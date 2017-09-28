package com.zhang.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhang .
 * DATA: 2017/6/13 .
 * Description : 数据库信息
 */

@Entity
public class StudentMsBean {
    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "STUDENTNUM")
    private String studentNum;

    @Property(nameInDb = "NAME")
    @NotNull
    private String name;

    private Integer num;

    @Generated(hash = 387484779)
    public StudentMsBean(Long id, String studentNum, @NotNull String name,
            Integer num) {
        this.id = id;
        this.studentNum = studentNum;
        this.name = name;
        this.num = num;
    }

    @Generated(hash = 1462084639)
    public StudentMsBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNum() {
        return this.studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
