package com.ccc.dao;

import com.ccc.bean.TblStudent;

import java.util.List;
import java.util.Map;

public interface TblStudentDao {


    /**
     * 第一种方式
     * map进行多条件查询
     * 01.把查询条件封装成map
     *
     */
    List<TblStudent> userByMap(Map<String,Object> map);

    /**
     * 第二种方式
     */
    List<TblStudent> userByMap2(String name,String Nname,String Mname);
}
