package com.qwm.spring2.c_proxy;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   22:43
 * @description：
 */
public class UserImpl implements IUser{
    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
        int i=1/0;
    }
}
