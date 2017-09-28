package com.zhang.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zhang .
 * DATA: 2017/9/26 .
 * Description :
 */

@Entity
public class TeacherMsBean {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "TEACHER_NAME")
    private String teacherName;

    @Generated(hash = 197220499)
    public TeacherMsBean(Long id, String teacherName) {
        this.id = id;
        this.teacherName = teacherName;
    }

    @Generated(hash = 602633011)
    public TeacherMsBean() {
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
