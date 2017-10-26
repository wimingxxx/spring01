package com.qwm.spring3.a_jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qwm.spring3.bean.User;
import com.qwm.spring3.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/10/26 0026   21:23
 * @description：
 * jdbc测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/qwm/spring3/applicationContext.xml")
public class Demo {

    @Resource(name = "userDao")
    private UserDao ud;

    /**
     * 不使用配置文件，直接调用JdbcTemplate来完成
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        //1.准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///stest");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("xm123456");

        //2.创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        //3.书写sql并且执行
        String sql = "insert into t_user values(null,'wiming')";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void test2(){
        User user = new User();
        user.setName("杞文明");
        ud.save(user);
    }

    @Test
    public void test3(){
        List<User> list = ud.getAll();
        System.out.println(list);
    }

    //----------------UserDaoImpl的调用--------------
    @Resource(name = "userDao2")
    private UserDao ud2;

    @Test
    public void test4(){
        User user = new User();
        user.setName("mingming");
        ud2.save(user);
    }

    @Test
    public void test5(){
        List<User> list = ud2.getAll();
        System.out.println(list);
    }
}
