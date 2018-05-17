package com.ccc;


import com.ccc.Util.SessionFactoryUtil;
import com.ccc.bean.TblStudent;
import com.ccc.dao.TblStudentDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.logging.Logger;


public class TblStudentTest {

    TblStudentDao tblstudent =null;
    SqlSession session=null;
    Logger logger =Logger.getLogger(TblStudentTest.class);
    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     *
     */
    @Before
    public void before(){

        session = SessionFactoryUtil.getSession();
        tblstudent=session.getMapper(TblStudentDao.class);
    }
    @After
    public void after(){
        if (session!=null){
            session.close();
        }
    }


}
