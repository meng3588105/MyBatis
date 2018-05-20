package com.mmm;

import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.Teacher;
import com.mmm.dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import org.apache.log4j.Logger;

public class TeacherTest {

    TeacherDao dao =null;
    SqlSession session =null;
    Logger logger =Logger.getLogger(TeacherTest.class);
    /**
     * 在所有test测试方法执行之前 都要执行的操作
     */

    @Before
    public void before(){
        //获取 session
        session = SessionFactoryUtil.getSession();
        dao=session.getMapper(TeacherDao.class);//获取执行的类对象
    }

    @After
    public  void after(){
        if (session!=null){
            session.close();
        }
    }

    @Test
    public void testSelectByTid(){
        List<Teacher> teachers =dao.selectTeachersByTid(1);
        logger.debug(teachers);
        //log.debug(teachers.get(0).getName()); //不会触发 只查询 tid为1的数据
    }

    @Test
    public void testSelectByTId(){
        Teacher teacher =dao.selectTeachersByTId(3);
        logger.debug(teacher);
        //log.debug(teacher.getName()); //1条sql
    }

}
