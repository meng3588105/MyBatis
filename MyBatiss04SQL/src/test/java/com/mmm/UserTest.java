package com.mmm;
import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.User;
import com.mmm.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserTest {
    UserDao dao =null;
    SqlSession session=null;
Logger logger =Logger.getLogger(UserTest.class);
/**
 * 在所有的test测试方法执行之前 都要执行的操作
 *
 */
@Before
public void before(){

    session = SessionFactoryUtil.getSession();
    dao=session.getMapper(UserDao.class);
}
@After
    public void after(){
    if (session!=null){
        session.close();
    }
}
    /**
     * 新增学生信息到数据库
     */
    @Test
    public   void  testAddStudent(){
        User user=new User(46,"嘿嘿");
        logger.debug("insert之前学生的编号："+user.getId());
        dao.addStudent(user);
        /**
         * 我们现在的新增对象中 只有age和name
         * id是mysql数据库给我们生成的
         * 你没有去mysql数据库中查询！
         * id肯定沒值！
         */
        logger.debug("insert之后学生的编号："+user.getId());
    }

    /**
     * 新增学生信息到数据库并且获取新增的id
     * -----------
     * 我们需要新增对象之后，接着对这个对象进行操作
     * 上面的新增方法不能实现
     *
     * 有一种方式 是在insert节点中新增一个seletkey节点
     * 在我们新增对象之后，连接没有立即放回连接池中。
     * 而是接着查询数据库中  刚刚插入数据的id
     * 这样我们的id就能获取了
     */
    @Test
    public void addID(){
        User user = new User(11,"哈哈");
        logger.debug("insert之前学生的编号："+user.getId());
        dao.addID(user);
        logger.debug("insert之后学生的编号"+user.getId());
        session.commit();
    }

    /**
     * 删除
     */
    @Test
    public void deleteUser(){
        dao.deleteUser(1);
        session.commit();
    }

    /**
     * 修改
     */

    @Test
    public void updateUser(){
        User user = new User(4,66,"么么");
        dao.updateUser(user);
        logger.debug("修改之后的学生信息是："+user);
        session.commit();
    }

    /**
     * 查询所有  返回list
     */
    @Test
    public void UserALL(){
        List<User>users = dao.UserALL();
        logger.debug(users);
    }
    /**
     *查询所有  返回map
     */
    @Test
    public void userAllMap(){

        List<Map<String,Object>> user=dao.userAllMap();
        logger.debug(user);
    }

    /**
     * 查询指定的user 返回User对象
     */
    @Test
    public void UserById(){
        User user = dao.UserById(6);
        //获取一个对象
        logger.debug(user);
    }

    /**
     * 根据姓名模糊查询
     */
    @Test
    public void userByName(){
        List<User> users = dao.userByname("嘿");
        //获取一个对象
        logger.debug(users);
    }


    /**
     * map多条件查询
     *
     */
    @Test
    public void userByMap(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name","嘿嘿");
        map.put("age",46);

        List<User>users=dao.userByMap(map);

        logger.debug(users);

    }

    /**
     *map多条件查询  下标
     */
    @Test
    public void  userByMap2(){
       List<User> list =dao.userByMap2("么么","N环境","M啦啦");
       logger.debug(list);
    }

    /**
     * 注解方式
     */

    @Test
    public void userByMap3(){
        List<User> list=dao.userByMap3("嘿嘿",4);
        logger.debug(list);
    }

    /**
     * map where 1=1
     */
    @Test
    public void userByIf(){
        User user =new User();

        //01 用户什么属性都没有赋值
        //02 用户传递了 name
        //03 用户传递了 age
        //04 用户都传递了

        user.setAge(45);
        user.setName("啦");

        List<User> users =dao.userByIf(user);

        logger.debug(users);

    }

    /**
     * <where>  替换  where 1=1
     */
    @Test
    public void userByIfWhere(){
        User user = new User();

        //01 用户什么属性都没有赋值
        //02 用户传递了 name
        //03 用户传递了 age
        //04 用户都传递了
        user.setAge(45);

        user.setName("啦");

        List<User> users =dao.userByIf(user);

        logger.debug(users);

    }


    @Test
    public void TestChoose(){
        User user =new User();
        /*
        * 01.name属性不为空  按照name 查询student.setName("小");
        * 02.age属性不为空  按照age 查询 student.setAge(555);
        * 03.两个属性都有值    student.setName("小");    student.setAge(555);
        * 04.两个属性都没有值
        */
        user.setAge(45);


        List<User> users = dao.userByChoose(user);
        logger.debug(users);


    }


    /**
     * foreach 遍历数组
     */
    @Test
    public void TestForeachArray(){

        int[] nums = {4,5};
        List<User> users = dao.userByforeachArray(nums);
        logger.debug(users);

    }

    /**
     *  foreach 遍历List
     */
    @Test
    public void TestForeachList(){

        List<Integer> lists = new ArrayList<Integer>();

        lists.add(2);
        lists.add(3);
        lists.add(4);
        List<User> users = dao.userByforeachList(lists);

    }

    /**
     * foreach 遍历对象集合
     */
    @Test
    public void TestFpreachUser(){
        List<User> lists =new ArrayList<User>();
        lists.add(new User(1));
        lists.add(new User(2));
        lists.add(new User(3));
        List<User> users = dao.userByForeachuser(lists);
        logger.debug(users);

    }

    /**
     * foreach 遍历map集合
     */
    @Test
    public void  testMapFroeah(){

        Map<String,Object>map = new HashMap<String,Object>();

        map.put("2","Object2");
        map.put("3","Object3");
        map.put("4","Object4");
        map.put("5","Object5");

        List<User> users = dao.userByForeachMap(map);
        logger.debug(users);
    }










}
