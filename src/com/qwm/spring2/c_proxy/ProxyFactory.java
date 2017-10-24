package com.qwm.spring2.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   22:28
 * @description：
 * 获取代理
 */
public class ProxyFactory {
    public static Object getProxyObject(Object target,Advice advice){
        if(target==null){
            throw new IllegalArgumentException("target can not null");
        }
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                if(advice==null){//如果没有通知，那么直接调用
                    obj = method.invoke(target,args);
                }else{
                    advice.before();
                    try {
                        advice.around(target, method, args);
                        obj = method.invoke(target, args);
                        advice.afterReturning();
                        advice.after();
                    }catch (Exception e){
//                        e.printStackTrace();
                        advice.after();
                        advice.afterException();
                    }
                }
                return obj;
            }
        });
    }
}
