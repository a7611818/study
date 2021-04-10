package com.shengsiyuan.boot.domain;


import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;

public class Test02 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class clazz = Class.forName("com.shengsiyuan.boot.kafka.Test01");
        Object o = ReflectionUtils.accessibleConstructor(clazz).newInstance();
    }
}
