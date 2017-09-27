package com.qwm.spring1.bean;
/**
 * @author: wiming
 * @date: 2017-09-27 14:59:50  星期三
 * @decription:
 */
public class Car {
    private String color;
    private String name;

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override public String toString() { return "Car{color='" + color + '\'' + ", name='" + name + '\'' + '}'; }
}