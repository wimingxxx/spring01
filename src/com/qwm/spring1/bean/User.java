package com.qwm.spring1.bean;

import java.io.Serializable;

/**
 * @author: wiming
 * @date: 2017-09-25 14:45:56  星期一
 * @decription:
 */
public class User implements Serializable {
    private String name;
    private int age;
    private Car car;

    public User() {
        System.out.println("User实例化了----" + this);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法: User(String name, int age)");
    }

    public User(int name, int age) {
        this.name = name + "";
        this.age = age;
        System.out.println("构造方法: User(int name, int age)");
    }

    public User(int age, String name) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法: User(int age, String name)");
    }

    public User(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
        System.out.println("构造方法: User(String name, int age, Car car)");
    }

    public void init() { System.out.println("---User---init---"); }
    public void destory() { System.out.println("---User---destory---"); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    @Override
    public String toString() {
        return "User{name='" + name + '\'' + ", age=" + age + ", car=" + car + '}';
    }
}