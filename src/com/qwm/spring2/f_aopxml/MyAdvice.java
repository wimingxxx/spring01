package com.qwm.spring2.f_aopxml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author：qiwenming
 * @date：2017/10/25 0025   23:10
 * @description：
 *  通知类
 */
public class MyAdvice {

    //前置通知
    //指定该方法是前置通知,并制定切入点
    public void before(){
        System.out.println("这是前置通知!!");
    }

    //后置通知
    public void afterReturning(){
        System.out.println("这是后置通知(如果出现异常不会调用)!!");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!!");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分!!");
        return proceed;
    }

    //异常通知
    public void afterException(){
        System.out.println("出事啦!出现异常了!!");
    }

    //后置通知
    public void after(){
        System.out.println("这是后置通知(出现异常也会调用)!!");
    }
}