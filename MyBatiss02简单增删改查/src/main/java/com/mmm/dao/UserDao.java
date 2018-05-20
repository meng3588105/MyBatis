package com.mmm.dao;

import com.mmm.bean.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 新增
     * @param user
     */
    void addStudent(User user);
    /**
     * 新增返回ID
     */
    void addID(User user);
    /**
     * 删除
     */
    void deleteUser(Serializable id);
    /**
     * 修改
     */
    void updateUser(User user);

    /**
     * 查询所有
     */
    List<User> UserALL();

    /**
     * 查询所有返回map集合
     */
    List<Map<String,Object>> userAllMap();

    /**
     * 查询指定id
     */
    User UserById(Serializable id);

    /**
     * 根据姓名模糊查询
     */
    List<User> userByname(String name);

}
