package com.qwm.spring1.b_beans;
import com.qwm.spring1.bean.User;

/**
 * @author: wiming
 * @date: 2017-09-25 16:48:14  星期一
 * @decription:
 * 创建User的工厂
 */
public class UserFactory {
    public static User createUser(){
        System.out.println("静态工厂创建User");
        return new User();
    }

    public User createUser2(){
        System.out.println("实例工厂创建User");
        return new User();
    }
}
