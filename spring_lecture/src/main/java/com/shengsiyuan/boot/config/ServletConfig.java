package com.shengsiyuan.boot.config;

import com.shengsiyuan.boot.servlet.ServeltTest;
import com.shengsiyuan.boot.servlet.ServeltTest2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.addUrlMappings("/haha");
        servletServletRegistrationBean.setServlet(new ServeltTest());
        return servletServletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean2() {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.addUrlMappings("/haha2");
        servletServletRegistrationBean.setServlet(new ServeltTest2());
        return servletServletRegistrationBean;
    }
}
