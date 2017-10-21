package com.qwm.spring2.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author：qiwenming
 * @date：2017/10/12 0012   23:34
 * @description：
 */

@Component("car")
public class Car {
    @Value("玛莎拉蒂")
    private String name;

    @Value("绿色")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
