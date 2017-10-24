package com.qwm.spring2.c_proxy;

import org.junit.Test;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   22:41
 * @description：
 *  含有通知的动态代理的测试
 */
public class Demo2 {

    private UserImpl user = new UserImpl();

    @Test
    public void test1(){
        IUser iu= (IUser)ProxyFactory.getProxyObject(user, new MyAdvice());
//        iu.saveUser();
        iu.delete();
    }

    @Test
    public void test2(){
        IUser iu = (IUser)ProxyFactory.getProxyObject(new IUser() {
            @Override
            public void saveUser() {

            }

            @Override
            public void delete() {
                System.out.println("删除用户");
            }
        }, new Advice() {
            @Override
            public void before() {
                System.out.println("------before----");
            }

            @Override
            void after() {
                System.out.println("-----after-----");
            }
        });

        iu.delete();
    }
}
