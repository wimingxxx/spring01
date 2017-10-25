package com.qwm.spring2.e_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author：qiwenming
 * @date：2017/10/25 0025   21:59
 * @description：
 * cglib 代理
 * 其实是创建一个被代理对象的子类的实例，所以被代理类，不能被 final 修饰
 */
public class CglibProxyFactory implements MethodInterceptor{

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 动态生成一个新的类，使用无参构造函数创建指定的代理对象
     * @param target
     * @return
     */
    public Object getProxyObject(Object target){
        //被代理对象
        this.target = target;
        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //设置生成类的父类，其实就是 被代理的类
        enhancer.setSuperclass(target.getClass());
        //回调, Callback 的实现类，这里我们使用了 MethodInterceptor 接口
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxyObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("----方法执行之前----");
        Object obj = methodProxy.invoke(target,args);
        System.out.println("----方法执行之后----");
        return obj;
    }
}
