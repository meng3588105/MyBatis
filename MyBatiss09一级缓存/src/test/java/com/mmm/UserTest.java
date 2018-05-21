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


    @Test
    public void TestuserById(){

        User user = dao.userById(1);
        logger.debug("第一次从数据库中获取的数据==》"+user);
        //再次查询id=1的老师信息
        user =dao.userById(1);
        logger.debug("第二次冲以及缓存中获取数据===》"+user);//只有一条sql语句产生

        /*
        * 01.缓存在底层存储都是key value ！value 就是查询的结果  关键是 key 是谁？？
        * 02.数据在做增删改的时候 会不会清理缓存？ 会
        *
        * */

    }

    /**
     * 验证 mybatis 的一级缓存 的key
     * sql语句是一样一样的
     * sql的id不一致
     *
     * 导致走了两次数据库
     *
     * key 的组成是 sql的id +sql语句
     * 01。方法名就是我们的id   有可能重复
     * 02.如果id 一致 那么sql 肯定不一致
     * 03.目的就是确保我们key的唯一性
     *
     *
     */

    @Test
    public void TestuserById2(){
        User user =dao.userById(1);
        logger.debug("第一次从数据库中获取数据==》"+user);
        //再次查询 id=1的信息
        user=dao.userById2(1);
        logger.debug("第二次从数据库中获取数据==》"+user);

    }


    /**
     * 一级缓存 是存在 sqlSession中的缓存
     * 一个会话对应一个sqlSession
     */
    /**
     * 验证数据再做增删改的时候  会不会 清理缓存？
     * 会的！
     */
    @Test
    public void testByAdd(){
        User user =dao.userById(1);
        logger.debug("第一次从数据库中获取数据==》"+user);
        /**
         * 新增一条数据
         * 01.数据在commit之前执行缓存清理
         * 02.缓存清理就会把之前缓存中的数据清空
         * 03.所以我们再次查询会找数据库
         *
         *
         public void commit(boolean required) throws SQLException {
         if (this.closed) {
         throw new ExecutorException("Cannot commit, transaction is already closed");
         } else {
         this.clearLocalCache();  //清空本地缓存
         this.flushStatements();
         if (required) {
         this.transaction.commit();
         }
         }
         }
         */
        dao.insertUser(new User(6,33,"天天"));
        session.commit();
        //再次传id=1的老师信息
        user=dao.userById(1);
        logger.debug("第二次应该从缓存中获取数据===》"+user);

    }




}
