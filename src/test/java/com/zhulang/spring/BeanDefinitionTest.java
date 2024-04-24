package com.zhulang.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Author Nozomi
 * @Date 2024/4/24 20:29
 */

public class BeanDefinitionTest {
    Logger log = LoggerFactory.getLogger(BeanDefinitionTest.class);

    @Test
    public void testGenericBeanDefinition() {
        // 1、定义一个GenericBeanDefinition
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.zhulang.spring.bean.User");
        beanDefinition.setLazyInit(false);
        // 2、创建一个MutablePropertyValues，用于设置属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name", "zl");
        mutablePropertyValues.add("age", 18);
        beanDefinition.setPropertyValues(mutablePropertyValues);
        log.info("beanDefinition:{}", beanDefinition);
    }

    @Test
    public void testRootBeanDefinition() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.zhulang.spring.bean.User");
        beanDefinition.setLazyInit(false);
        // 创建一个MutablePropertyValues
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name", "ydl");
        mutablePropertyValues.add("age", 18);
        beanDefinition.setPropertyValues(mutablePropertyValues);
        System.out.println(beanDefinition);

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.overrideFrom(beanDefinition);
        System.out.println("----------------------------");
        System.out.println(rootBeanDefinition);
    }

    @Test
    public void testChildBeanDefinition() {
        GenericBeanDefinition dog = new GenericBeanDefinition();
        dog.setBeanClassName("com.zhulang.spring.bean.Dog");
        BeanMetadataAttribute color = new BeanMetadataAttribute("color","white");
        BeanMetadataAttribute age = new BeanMetadataAttribute("age","3");
        dog.addMetadataAttribute(color);
        dog.addMetadataAttribute(age);

        // 子Definition的创建需要依赖父Definition
        ChildBeanDefinition teddy = new ChildBeanDefinition("dog");
        teddy.setBeanClassName("com.zhulang.spring.bean.TeddyDog");
        BeanMetadataAttribute name = new BeanMetadataAttribute("name","doudou");
        teddy.addMetadataAttribute(name);
    }
}
