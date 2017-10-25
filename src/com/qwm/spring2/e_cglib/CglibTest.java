package com.qwm.spring2.e_cglib;

import org.junit.Test;

/**
 * @author：qiwenming
 * @date：2017/10/25 0025   22:12
 * @description：
 */
public class CglibTest {

    @Test
    public void test(){
        //目标类
        MyObject myObject = new MyObject();
        //代理工厂
        CglibProxyFactory factory = new CglibProxyFactory();
        //创建代理类
        MyObject proxyObj = (MyObject) factory.getProxyObject(myObject );
        //调用方法
        proxyObj.currentTime();
    }

}
