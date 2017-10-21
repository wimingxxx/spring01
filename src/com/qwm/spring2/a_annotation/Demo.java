package com.qwm.spring2.a_annotation;

import com.qwm.spring2.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：qiwenming
 * @date：2017/10/12 0012   23:39
 * @description：注解 测试
 */
public class Demo {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/qwm/spring2/applicationContext.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
        ac.close();
    }
}
