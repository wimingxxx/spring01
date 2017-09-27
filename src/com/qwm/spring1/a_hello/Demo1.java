package com.qwm.spring1.a_hello;

import com.qwm.spring1.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wiming
 * @date: 2017-09-25 14:51:06  星期一
 * @decription:
 * 第一个示例
 */
public class Demo1 {
    @Test
    public void test1(){
        //创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取User的对象
        User user = (User)context.getBean("user");
        //打印
        System.out.println(user);
    }
}
