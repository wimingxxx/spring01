package com.qwm.spring2.g_aopannotation;

import com.qwm.spring2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/10/25 0025   23:38
 * @description：
 * Aop xml 配置测试
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:com/qwm/spring2/g_aopannotation/applicationContext.xml")
public class AopAnnotationTest {

    @Resource(name = "userService")
    public UserService us;

    @Test
    public void test1(){
        us.saveUser();
    }

    @Test
    public void test2(){
        us.deleteUser();
    }
}