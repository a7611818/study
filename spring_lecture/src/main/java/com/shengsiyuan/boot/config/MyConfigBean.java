package com.shengsiyuan.boot.config;

import org.springframework.beans.factory.annotation.Value;

public class MyConfigBean {

    @Value("${myConfig.myObject.myName}")
    private String myName;
    @Value("${myConfig.myObject.myAge}")
    private String myAge;

    public String getMyAge() {
        return this.myAge;
    }

    public void setMyAge(String myAge) {
        this.myAge = myAge;
    }

    public String getMyName() {
        return this.myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

}
