package com.mmm.bean;

import java.util.Set;

public class Teacher {
    /**
     *  老师和导师对应的实体类  自连接
     *
     */
    private  Integer id ; //老师编号
    private  String name;//老师姓名

    //多个老师对应一个导师
    private Teacher teacher;

    public Teacher(Integer id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Teacher() {
        super();
    }
}
