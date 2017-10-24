package com.qwm.spring2.c_proxy;

import org.aopalliance.intercept.Invocation;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author：qiwenming
 * @date：2017/10/22 0022   22:03
 * @description：
 * 动态代理
 */
public class Demo {

    /**
     * 获取代理类
     */
    @Test
    public void test1(){
        //1.获取代理类
        Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
        System.out.println(clazzProxy.getName());

        //2.获取构造方法,并且打印出来
        Constructor[] constructors = clazzProxy.getConstructors();
        System.out.println("--------constructors list--------");
        for (Constructor constructor : constructors) {
            StringBuilder sb = new StringBuilder( constructor.getName() );
            sb.append('(');
            Class[] clazzParams = constructor.getParameterTypes();
            for (Class clazzParam : clazzParams) {
                sb.append(clazzParam.getName()).append(",");
            }
            //删除最后一个逗号
            if(clazzParams!=null && clazzParams.length !=0){
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(')');
            System.out.println(sb.toString());
        }

        //3.获取方法,并且打印
        Method[] methods = clazzProxy.getMethods();
        System.out.println("--------methods list--------");
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder( method.getName() );
            sb.append('(');
            Class[] clazzParams = method.getParameterTypes();
            for (Class clazzParam : clazzParams) {
                sb.append(clazzParam.getName()).append(",");
            }
            //删除最后一个逗号
            if(clazzParams!=null && clazzParams.length !=0){
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(')');
            System.out.println(sb.toString());
        }
    }

    /**
     * 通过构造函数来创建代理实例
     */
    @Test
    public void test2() throws Exception {
        //1.创建一个代理类
        Class clazzProxy = Proxy.getProxyClass(ArrayList.class.getClassLoader(),ArrayList.class.getInterfaces());

        //2.获取构造方法
        Constructor constructor = clazzProxy.getConstructor(InvocationHandler.class);

        //3.通过构造方法创建实例
        Collection arrayListProxy = (Collection) constructor.newInstance(new MyInvocationHandler(new ArrayList()));

//       4.添加数据
        arrayListProxy.add("1");
        arrayListProxy.add("2");

        arrayListProxy.isEmpty();
        arrayListProxy.remove("2");
    }

    @Test
    public void test3(){
        Collection arrayListProxy = (Collection)Proxy.newProxyInstance(HashSet.class.getClassLoader(),HashSet.class.getInterfaces(),new MyInvocationHandler(new HashSet()));
        arrayListProxy.add("jjj");
    }

    public class MyInvocationHandler implements InvocationHandler{

        private Object target;

        public MyInvocationHandler(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("----------------------------");
            System.out.println(method.getName() + " : 方法调用之前----");
            Object obj = method.invoke(target,args);
            System.out.println(method.getName() + " : 方法掉用之后");
            System.out.println("----------------------------");
            return obj;
        }
    }

    @Test
    public void test4(){
        List list = (List)getProxyObject(new LinkedList());
        list.add("xiaoming");
        list.clear();
    }

    public Object getProxyObject(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new MyInvocationHandler(obj));
    }

    @Test
    public void test5(){
         Map map = (Map)getProxyObj(new HashMap());
         map.put("name","xiaoming");
         map.remove("name");
    }

    public Object getProxyObj(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------------------------");
                System.out.println(method.getName() + " : 方法调用之前----");
                Object obj = method.invoke(target,args);
                System.out.println(method.getName() + " : 方法掉用之后");
                System.out.println("----------------------------");
                return obj;
            }
        });
    }
}
