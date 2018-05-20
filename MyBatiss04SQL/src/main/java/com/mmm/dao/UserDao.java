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

    /**
     * 动态查询
     */
    /**
     * 01.用户传递User对象  但是我们不知道用户对那些属性赋了值
     */
    List<User> userByIf(User user);

    /**
     * 02.where 标签 替换where 1=1
     *
     */
    List<User> userByWhere(User user);

    /**
     * 03.choose标签
     *
     * 当我们的年龄不为空  按照年龄查询
     *
     * 当我们的姓名不为空 按照姓名查询
     *
     * 如果都会空 执行一个标签 otherwise
     */

    List<User> userByChoose(User user);

    /**
     * 04.foreach 遍历数组
     */

    List<User> userByforeachArray(int [] nums);

    /**
     * 05.foreach 遍历List
     */
    List<User> userByforeachList(List<Integer>users);

    /**
     * 06.foreach遍历对象集合
     */
    List<User> userByForeachuser(List<User> users);

    /**
     * foreach 遍历Map集合
     */

    List<User> userByForeachMap(@Param("myMap") Map<String,Object> map);




}
