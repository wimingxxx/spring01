package com.qwm.spring2.d_myaop;

import java.lang.reflect.Method;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   22:18
 * @description：
 * 通知类
 */
public class MyAdvice extends Advice {

    @Override
    public void before() {
        System.out.println("------before方法调用之前（前置通知）-----");
    }

    @Override
    public void afterReturning() {
        System.out.println("------afterReturning方法调用之后（后置通知 ,异常了不会调用)-----");
    }

    @Override
    public void around(Object target, Method method, Object[] args) {
        System.out.println("----------around（环绕通知）方法调用之前----------");
        try {
            method.invoke(target,args);
            System.out.println("----------around（环绕通知）方法调用之后----------");
        } catch (Exception e) {}
    }

    @Override
    public void afterException() {
        System.out.println("-------异常时候调用（异常通知）--------");
    }

    @Override
    public void after() {
        System.out.println("-------方法调用之后（后置通知）异常也调用---------");
    }
}
