package com.mmm.dao;

import com.mmm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserDao {


    /**
     * 根据id查询指定信息
     */
    User userById(Serializable id);


    /**
     * 新增user
     */
    void insertUser(User user);



}
