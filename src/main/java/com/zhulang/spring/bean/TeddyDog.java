package com.zhulang.spring.bean;

/**
 * @Author Nozomi
 * @Date 2024/4/24 20:36
 */
//@Component
public class TeddyDog extends Dog  {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeddyDog{" +
                "name='" + name + '\'' +
                '}';
    }

}
