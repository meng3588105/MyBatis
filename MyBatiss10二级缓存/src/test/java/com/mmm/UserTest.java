package com.mmm;
import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.User;
import com.mmm.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
     *
     * MyBatis的二级缓存的配置
     * 01.引入jar包 和 ehcache.xml文件
     * 02.在ehcache.xml文件去书写对应的配置
     * 03.需要缓存的类  需要实现序列化的接口
     * 04.在对应mapper文件中设置 <cache/>
     *
     */

    /**
     *[DEBUG] com.mmm.UserTest 42 第一次从数据库中获取的数据==》User{id=1, age=45, name='偶记'}
     [DEBUG] com.mmm.UserTest 45 第二次从一级缓存中获取数据===》User{id=1, age=45, name='偶记'}

        步骤：
            01.当我们查询id=1的信息时
            02.先从一级缓存中查询，没有，之后 如果我们配置了2级缓存 ，就去2级缓存中查询
            03.如果2级缓存也没有，就回去数据库中查询  所以得到了
     [DEBUG] com.mmm.UserTest 42 第一次从数据库中获取的数据==》User{id=1, age=45, name='偶记'}
            04.第二次查询的时候先从一级缓存中查询，一级缓存中存在数据 直接使用
                所以2及缓存的命中率是0.0

     */
    @Test
    public void testSelectBySid(){

        User user =dao.userById(1);
        logger.debug("第一次从数据库中获取数据===》"+user);
        //再次查询id=1的信息
        user = dao.userById(1);
        logger.debug("第二次从一级缓存中获取数据===》"+user);

    }

    /**
     * 验证2级缓存配置成功
     */
    /**
     * 01.先去一级缓存中查询  没有！
     * 02.去二级缓存中查询  没有！
     * 03.去数据库查询    SELECT * from USER where id=?
     * 04.输出结果
     *[DEBUG] com.mmm.UserTest 65 第一次从数据库中获取数据===》User{id=1, age=45, name='偶记'}
     * 05.session关闭了  一级缓存中的数据被清空
     * 06.因为我们设置了二级缓存，所以数据会在2级缓存中保存
     * 07.第二次查询  先去一级缓存中查询  session关闭没有
     * 08.去二级缓存中查询   有
     * 09.Cache Hit Ratio [com.xdf.dao.TeacherDao]: 0.5
     * 10.从二级缓存中得到结果
     * [DEBUG] com.mmm.UserTest 102 第二次从二级缓存中获取数据===》User{id=1, age=45, name='偶记'}
     *
     [DEBUG] com.mmm.UserTest 93 第一次从数据库中获取数据===》User{id=1, age=45, name='偶记'}
     [DEBUG] com.mmm.dao.UserDao.userById 142 ==>  Preparing: SELECT * FROM USER WHERE id=?
     [DEBUG] com.mmm.dao.UserDao.userById 142 ==> Parameters: 1(Integer)
     [DEBUG] com.mmm.dao.UserDao.userById 148 <==    Columns: id, age, name, Nid, Mid
     [DEBUG] com.mmm.dao.UserDao.userById 148 <==        Row: 1, 45, 偶记, 1, 1
     [DEBUG] com.mmm.dao.UserDao.userById 142 <==      Total: 1
     [DEBUG] com.mmm.UserTest 102 第二次从二级缓存中获取数据===》User{id=1, age=45, name='偶记'}
     [DEBUG] com.mmm.dao.UserDao.userById 142 ==>  Preparing: SELECT * FROM USER WHERE id=?
     [DEBUG] com.mmm.dao.UserDao.userById 142 ==> Parameters: 2(Integer)
     [DEBUG] com.mmm.dao.UserDao.userById 148 <==    Columns: id, age, name, Nid, Mid
     [DEBUG] com.mmm.dao.UserDao.userById 148 <==        Row: 2, 45, 啦啦, 2, 2
     [DEBUG] com.mmm.dao.UserDao.userById 142 <==      Total: 1
     [DEBUG] com.mmm.UserTest 104 第三次从二级缓存中获取数据===》User{id=2, age=45, name='啦啦'}

     */

    @Test
    public void testSelectBySid2(){

        User user =dao.userById(1);
        logger.debug("第一次从数据库中获取数据===》"+user);
        //关闭session   一级缓存中的数据被清空
        session.close();
        //再次获取session
        session=SessionFactoryUtil.getSession();
        dao=session.getMapper(UserDao.class);//获取执行类的对象
        //再次查询id=1的信息
        user =dao.userById(1);

        logger.debug("第二次从二级缓存中获取数据===》"+user);
        user=dao.userById(2);
        logger.debug("第三次从二级缓存中获取数据===》"+user);

    }
/**
 *
 * 2级缓存的局部关闭
 * 在对应mapper文件中的节点中  增加  useCache=false
 */
    @Test
    public void  testSelectByClose(){

        User user =dao.userById(1);
        logger.debug("第一次从数据库中获取数据===》"+user);
        //关闭session 一级缓存中的数据被清空
        session.close();
        session=SessionFactoryUtil.getSession();
        dao=session.getMapper(UserDao.class);//获取执行的类的对象
        //再次查询id=1的老师信息
        user=dao.userById(1);
        logger.debug("第二次从二级缓存中获取数据===》"+user);


    }

    /**
     * 增删改  也是 清空 2级缓存！
     */


}

