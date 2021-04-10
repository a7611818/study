package com.shengsiyuan.boot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TestCondition implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String city = context.getEnvironment().getProperty("person.address.city");
        if ("dalian".equals(city)) {
            return true;
        }
        return false;
    }
}
