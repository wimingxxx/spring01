package com.qwm.spring1.bean;
import java.io.Serializable;
/**
 * @author: wiming
 * @date: 2017-09-25 14:45:56  星期一
 * @decription:
 */
public class User implements Serializable{
    private String name;
    private int age;

    public User() {
        System.out.println("User实例化了----" + this);
    }

    public void init(){
        System.out.println("---User---init---");
    }

    public void destory(){
        System.out.println("---User---destory---");
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}
