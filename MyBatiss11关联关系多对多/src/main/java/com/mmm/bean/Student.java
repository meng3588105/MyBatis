package com.mmm.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生对应的实体类
 */
public class Student {

    private Integer sid; //学生id
    private Integer age;   //学生学号
    private String sname;   //学生姓名

    //一个学还是呢过可以有多个老师
    private Set<Teacher> teachers =new HashSet<Teacher>();

    public Student(Integer sid, Integer age, String sname, Set<Teacher> teachers) {
        this.sid = sid;
        this.age = age;
        this.sname = sname;
        this.teachers = teachers;
    }


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }


    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", age=" + age +
                ", sname='" + sname + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
