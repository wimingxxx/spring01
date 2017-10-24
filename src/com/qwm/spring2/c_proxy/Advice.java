package com.qwm.spring2.c_proxy;
import java.lang.reflect.Method;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   22:20
 * @description：
 * 通知抽象类
 */
public abstract class Advice {
    /**
     * 方法调用之前（前置通知）
     */
    public void before(){}

    /**
     * 方法调用之后（后置通知）
     * 异常了不会调用
     */
    void afterReturning(){}

    /**
     * 可以自己调用方法（环绕通知）
     */
    void around(Object proxy, Method method, Object[] args){}

    /**
     * 异常时候调用（异常通知）
     */
    void afterException(){}

    /**
     * 方法调用之后（后置通知）
     * 异常了也会调用
     */
    void after(){}
}
