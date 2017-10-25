package com.qwm.spring2.service;

/**
 * @author：qiwenming
 * @date：2017/10/25 0025   23:07
 * @description：
 */
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("--保存用户--");
    }

    @Override
    public void deleteUser() {
        System.out.println("--删除用户--");
        //为了测试异常通知，弄出一异常
        int i = 1 / 0;
    }

    @Override
    public void updateUser() {
        System.out.println("--更新用户--");
    }

    @Override
    public void findUser() {
        System.out.println("--查找用户--");
    }
}