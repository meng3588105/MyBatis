package com.mmm;
import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.Country;
import com.mmm.bean.User;
import com.mmm.dao.CountryDao;
import com.mmm.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CountryTest {
    CountryDao dao =null;
    SqlSession session=null;
Logger logger =Logger.getLogger(CountryTest.class);
/**
 * 在所有的test测试方法执行之前 都要执行的操作
 *
 */
@Before
public void before(){

    session = SessionFactoryUtil.getSession();
    dao=session.getMapper(CountryDao .class);//获取执行的类对象
}
@After
    public void after(){
    if (session!=null){
        session.close();
    }
}

/**
 * 根据国家的编号 查询出 国家对应省会的信息
 * 没有延迟加载
 */

@Test
    public void selectCountry(){
    Country country =dao.selectContryById(1);
    logger.debug(country);
}
    /**
     * 根据国家的编号  查询出 国家对应省会的信息
     * 设置延迟加载
     *01.在mybati核心配置文件中 增加setting节点
     *02.节点中增加
     *  <setting name="lazyLoadingEnabled" value="true"/>
     *   <setting name="aggressiveLazyLoading" value="false"/>
     */
@Test
    public void selectCountryLazy(){
        Country country =dao.selectContryById(2);
        logger.debug(country.getcName());//只查询国家的名称 如果开启了延迟加载有1条sql
        logger.debug(country.getcName());//只查询国家的名称 如果开启了延迟加载有2条sql
        logger.debug(country.getProvincials());//查询国家对应的省会  无论有没有开启了延迟加载都有2条sql
}




}
