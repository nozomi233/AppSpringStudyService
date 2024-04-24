package com.zhulang.spring.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * @Author Nozomi
 * @Date 2024/4/24 20:31
 */

@Component
@Order(5)
//@Scope(proxyMode = ScopedProxyMode.INTERFACES, value = "prototype")
public class Dog {
    private String color;
    private Integer age;

    public Dog() {
    }

    public Dog(String color, Integer age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
