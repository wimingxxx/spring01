package com.qwm.spring2.d_myaop;

import org.junit.Test;

import java.io.InputStream;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   23:34
 * @description：
 * 自己的Aop测试
 */
public class MyAopTest {
    @Test
    public void test1(){
        //获取配置文件
        InputStream ips = MyAopTest.class.getResourceAsStream("config.properties");
        //获取到代理对象
        Object object = new BeanFactory(ips).getBean("bean");
        System.out.println(object.getClass().getName());
    }
}
