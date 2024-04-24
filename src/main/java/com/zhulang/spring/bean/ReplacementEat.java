package com.zhulang.spring.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ReplacementEat implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("开始吃饭...");
//		method.invoke(obj,args);
        System.out.println("好香好香..");
        return null;
    }
}
