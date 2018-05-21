package com.mmm.dao;

import com.mmm.bean.Student;
import com.mmm.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {

    /**
     * 根据学生的编号  查询出对应的所有老师信息
     */
    Student selectTeachersBySid(Serializable id);

    /**
     * 根据老师的编号 查询出 对应的所有学生信息
     */
    Teacher selectStudentsByTid(Serializable id);


}
