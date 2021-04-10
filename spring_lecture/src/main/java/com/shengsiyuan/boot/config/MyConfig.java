package com.shengsiyuan.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ybq
 */
@Configuration
public class MyConfig {

    @Bean
    public MyConfigBean myConfigBean() {
        return new MyConfigBean();
    }
}
