package com.zhulang.spring.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.core.PriorityOrdered;

import java.util.Base64;
/**
 * @Author Nozomi
 * @Date 2024/4/24 20:39
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered {

    // 会在bean工厂创建完成之后被调用
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition("user");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        Object value = propertyValues.getPropertyValue("name").getValue();

        if(value instanceof TypedStringValue name){
            byte[] decodedBytes = Base64.getDecoder().decode(name.getValue());
            String decodedString = new String(decodedBytes);
            System.out.println("Base64解密后：" + decodedString);

            propertyValues.addPropertyValue("name",decodedString);

            System.out.println("-----------------");
        }

    }

    @Override
    public int getOrder() {
        return 2;
    }
}
