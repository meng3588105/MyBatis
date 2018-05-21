package com.mmm;

import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.Student;
import com.mmm.bean.Teacher;
import com.mmm.dao.TeacherDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TeacherTest {

    TeacherDao Mapper=null;
    SqlSession session =null;
    Logger logger =Logger.getLogger(TeacherTest.class);

    /**
     * 再有所有test测试方法执行之前 都要执行的操作
     */
    @Before
    public  void before(){

        //获取session
        session = SessionFactoryUtil.getSession();
        Mapper=session.getMapper(TeacherDao.class);
    }
    @After
    public void after(){
        if (session!=null){
            session.close();
        }
    }

    @Test
    public void testSelectBySid(){
        Student student =Mapper.selectTeachersBySid(2);
        logger.debug(student);
    }

    @Test
    public void testSelectByTid(){

        Teacher teacher =Mapper.selectStudentsByTid(1);
        logger.debug(teacher);

    }


}
