package com.zhulang.spring.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.SmartLifecycle;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author Nozomi
 * @Date 2024/4/24 20:30
 */

@Component
@Order(2)
public class User implements SmartLifecycle {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Dog dog;

    private Integer age;
    @Value("tom")
    private String name;


    public User() {
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void eat(){
        System.out.println("我正在吃饭。");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void start() {
        System.out.println("------------start----------");
    }

    @Override
    public void stop() {
        System.out.println("------------stop----------");
    }

    @Override
    public boolean isRunning() {
        return false;
    }




//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
}
