package com.qwm.spring1.c_inject;

import com.qwm.spring1.bean.ComplexBean;
import com.qwm.spring1.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wiming
 * @date: 2017-09-27 15:05:30  星期三
 * @decription:
 * 注入测试
 */
public class Demo {
    /**
     * set 方式注入测试
     */
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user1 = (User) ac.getBean("user1");
        System.out.println(user1);
    }

    //==============================================================================

    /**
     * 构造方法 方式注入测试
     */
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user2");
        System.out.println(user);
    }

    /**
     * 构造方法 方式注入测试
     * 使用了 index
     */
    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user3");
        System.out.println(user);
    }

    /**
     * 构造方法 方式注入测试
     * 使用了 type
     */
    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user4");
        System.out.println(user);
    }

    /**
     * 构造方法 方式注入测试
     * 通过constructor-arg 中的ref指定引用
     */
    @Test
    public void test5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user5");
        System.out.println(user);
    }

    //==============================================================================

    /**
     * p名称空间注入测试
     */
    @Test
    public void test6(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user6");
        System.out.println(user);
    }

    //=====================================spel注入=========================================
    @Test
    public void test7(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        User user = (User) ac.getBean("user7");
        System.out.println(user);
    }

    //==========================================复杂类型注入=========================================

    /**
     * 复杂类型注入
     * 其中 array 和list只有一个的情况
     */
    @Test
    public void test8(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        ComplexBean com1 = (ComplexBean) ac.getBean("com1");
        System.out.println(com1);
    }

    /**
     * 复杂类型注入
     * 其中 array 和list有多个的情况
     */
    @Test
    public void test9(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring1/c_inject/applicationContext.xml");
        ComplexBean com2 = (ComplexBean) ac.getBean("com2");
        System.out.println(com2);
    }
}
