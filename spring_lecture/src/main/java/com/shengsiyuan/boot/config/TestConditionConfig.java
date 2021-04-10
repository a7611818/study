package com.shengsiyuan.boot.config;

import com.shengsiyuan.boot.condition.TestCondition;
import com.shengsiyuan.boot.condition.TestCondition2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author ybq
 */
@Configuration
public class TestConditionConfig {

    @Bean
    @Conditional(TestCondition.class)
    public String getConfig() {
        return "hello";
    }

    @Bean
    public String getConfig2() {
        return "world";
    }

    @Bean
    @Conditional({TestCondition.class, TestCondition2.class})
    public String getConfig3() {
        return "hello";
    }
}
