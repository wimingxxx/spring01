package com.qwm.spring2.b_junit;

import com.qwm.spring2.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/10/13 0013   0:13
 * @description：
 * spring与junit整合测试
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:com/qwm/spring2/applicationContext.xml")
public class Demo {

    //将名为User的对象注入到user变量中
    @Resource(name="user")
    private User user;

    @Test
    public void test1(){
        System.out.println(user);
    }
}
