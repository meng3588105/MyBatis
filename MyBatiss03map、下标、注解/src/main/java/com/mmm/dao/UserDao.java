package com.mmm.dao;

import com.mmm.bean.User;
import org.apache.ibatis.annotations.Param;

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
‘      * 新增返回ID
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

    /**
     * 第一种方式
     * map进行多条件查询
     * 01.把查询条件封装成map
     *
     */
    List<User> userByMap(Map<String,Object>map);

    /**
     * 第二种方式
     */
    List<User> userByMap2(String name,String Nname,String Mname);

    /**
     * 注解方式
     */

    List<User>  userByMap3(@Param("name") String name ,@Param("id")int id);






}
