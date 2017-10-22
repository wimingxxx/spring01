package com.qwm.spring2.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author：qiwenming
 * @date：2017/10/12 0012   23:34
 * @description：
 */
//@Component("user") //下面三个和这个其实是一样的，只是下面三个起到标识的作用
//@Service("user") // service层
//@Controller("user") // web层
@Repository("user")// dao层
//指定对象的作用范围
@Scope(scopeName="singleton")
public class User {
    @Value("wiming")
    private String name;

    @Value("18")
    private int age;

    //@Autowired //自动装配
    //问题:如果匹配多个类型一致的对象.将无法选择具体注入哪一个对象.

    //@Qualifier("car2")//使用@Qualifier注解告诉spring容器自动装配哪个名称的对象

    @Resource(name="car")//手动注入,指定注入哪个名称的对象
    private Car car;

    @PostConstruct //对象创建后调用
    public void init(){
        System.out.println("--初始化方法--");
    }

    @PreDestroy //对象销毁之前调用
    public void destory(){
        System.out.println("--销毁方法--");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
