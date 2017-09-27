package com.qwm.spring1.b_beans;

import com.qwm.spring1.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wiming
 * @date: 2017-09-25 16:06:12  星期一
 * @decription:
 */
public class Demo1 {
    @Test
    public void test1(){
        //1.创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取User对象
        User user1 = (User) applicationContext.getBean("user");
        User user2 = (User) applicationContext.getBean("user");
        User user3 = (User) applicationContext.getBean("user");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }

    /**
     * init 和 destory方法测试
     */
    @Test
    public void test2(){
        //1.创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取User对象
        User User_1 = (User) ac.getBean("user");
        System.out.println(User_1);
        //3.为了执行destory方法
        ac.close();
    }

    /**
     * 第一种创建方式：空参构造函数方式
     */
    @Test
    public void createWay1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User) ac.getBean("user1");
        System.out.println(user1);
    }

    /**
     * 第二种创建方式：静态工厂
     */
    @Test
    public void createWay2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = (User) ac.getBean("user2");
        System.out.println(user2);
    }

    /**
     * 第三种创建方式：实例工厂
     */
    @Test
    public void createWay3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user3 = (User) ac.getBean("user3");
        System.out.println(user3);
    }
}
