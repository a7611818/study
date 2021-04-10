package com.shengsiyuan.boot.domain;

import java.util.Date;

/**
 * @author ybq
 */
public class Person {
    private Integer id;
    private String name;
    private Date birthday;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
