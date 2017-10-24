package com.qwm.spring2.d_myaop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author：qiwenming
 * @date：2017/10/24 0024   23:01
 * @description：
 * Bean的工厂类
 */
public class BeanFactory {
    Properties props = new Properties();
    public BeanFactory(InputStream in){
        try {
            //加载配置文件
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取bean
     * @param name 配置文件中的名字
     * @return
     */
    public Object getBean(String name){
        String className = props.getProperty(name);
        if(className==null||className.trim().equals("")){
            throw new IllegalArgumentException(name + " not exits");
        }
        Object bean=null;
        //通过完整类名来创建一个实例
        try {
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bean instanceof ProxyFactoryBean){//如果需要代理
            Object proxyBean = null;
            ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;
            try {
                //获取通知和目标类，然后创建实例
                Advice advice = (Advice)Class.forName(props.getProperty(name+".advice")).newInstance();
                Object target = Class.forName( props.getProperty(name+".target")).newInstance();
                //设置
                proxyFactoryBean.setAdvice(advice);
                proxyFactoryBean.setTarget(target);
                proxyBean = proxyFactoryBean.getProxyObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proxyBean;
        }
        return bean;
    }
}
