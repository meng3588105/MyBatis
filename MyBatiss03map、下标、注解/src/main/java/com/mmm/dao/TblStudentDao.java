package com.mmm.dao;

import com.mmm.bean.User;

import java.util.List;
import java.util.Map;

public interface TblStudentDao {


    /**
     * 第一种方式
     * map进行多条件查询
     * 01.把查询条件封装成map
     *
     */
    List<User> studentByMap(Map<String,Object> map);
    /**
     * 第二种方式
     */
    List<User> studentByMap2(String name,String Nname,String Mname);



}
