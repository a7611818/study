package com.shengsiyuan.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ybq
 */
@Configuration
@Profile("hehe")
public class MyConfigHehe {

    @Bean
    public MyConfigBean myConfigBean() {
        MyConfigBean myConfigBean = new MyConfigBean();
        myConfigBean.setMyName("hehe");
        return myConfigBean;
    }
}
