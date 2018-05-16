package com.mmm.dao.Impl;

import com.mmm.Util.SessionFactoryUtil;
import com.mmm.bean.User;
import com.mmm.dao.UserDao;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class UserDaoImpl implements UserDao {
    /**
     * @param user  需要新增De 对象
     */

    @Override
    public void addStudent(User user) {
        //获取session
        SqlSession session = null;
        try {

            session= SessionFactoryUtil.getSession();
        /**
         * 参数1：是我们执行的sql语句id
         * 参数2：如果方法是带参的 需要执行这个参数
         * 注意点：
         *  01.底层没有insert，delete只有update
         *      001.点击insert观看源码
         *          新增操作
         *           public int insert(String statement, Object parameter) {
         *                return this.update(statement, parameter);
         *              }
         *              删除方法
                    public int delete(String statement) {
                         return this.update(statement, (Object)null);
                         }
         *
         *      002.最终执行的是update！你怎么知道    我到达执行的是新增还是删除呢？点进去update
         *           001.根据mapper.xml文件中的sql语句！
                     002.只有sql语句  就能更新到数据库吗？
                     003.底层有一个属性叫dirty  是否是脏数据


                    session.commit()执行的时候，会进行缓存清理和flush（）操作！
                    缓存清理的时候会判断我们的对象是否是脏对象！如果是脏对象就会进行
                    同步数据库的操作！之后再把dirty 属性变为false！
         */
            session.insert("addStudent", user);
            //手动提交事务
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //务必要关闭session
            session.close();
        }



    }

    /**
     * 新增并且获取id
     * @param user
     */
    public void addID(User user){

        //获取session
        SqlSession session  =null;
        try {
            session = SessionFactoryUtil.getSession();
            session.insert("addID", user);
            //手动提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteUser(Serializable id) {
        //获取session
        SqlSession session = null;
        try {
            session = SessionFactoryUtil.getSession();
            //删除操作
            session.delete("deleteUser",id);
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /**
     * 修改
     */
    public void updateUser(User user){
        //获取session
        SqlSession session =null;
        try{
            session = SessionFactoryUtil.getSession();
            //修改操作
            session.update("updateUser",user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * 查询所有
     */
    @Override
    public List<User> UserALL() {
        //获取session
        SqlSession session =null;
        List<User>users=null;
        try {
            session = SessionFactoryUtil.getSession();
            //查询所有
            session.selectList("UserALL");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }

    /**
     *查询所有返回map集合
     */
    @Override
    public Map<String, Object> userAllMap() {
        //获取session
        SqlSession session = null;
        Map<String,Object> user = null;
        try {
            session = SessionFactoryUtil.getSession();
            //查询所有操作  返回map  s1：map集合中的key
            user =session.selectMap("userAllMap","name");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        session.close();
        }
        return user;
    }

    /**
     * 查询指定的id
     * @param id
     * @return
     */
    @Override
    public User UserById(Serializable id) {
        //获取session
        SqlSession session =null;
        User user = null;
        try {
            session = SessionFactoryUtil.getSession();

            user=session.selectOne("UserById",id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    /**
     * 根据姓名进行模糊查询
     * @param name
     * @return
     */
    @Override
    public List<User> userByname(String name) {
        //获取session
        SqlSession session = null;
        List<User> users = null;
        try{
            session=SessionFactoryUtil.getSession();
            users=session.selectList("userByname",name);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }


}
