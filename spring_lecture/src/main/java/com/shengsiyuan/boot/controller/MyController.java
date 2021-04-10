package com.shengsiyuan.boot.controller;

import com.shengsiyuan.boot.config.MyConfigBean;
import com.shengsiyuan.boot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ybq
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {

    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private String myAge;

    @Autowired
    private MyConfigBean myConfigBean;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson() {
        Person person = new Person();
        person.setId(25);
        person.setName("张三");
        person.setBirthday(new Date());

//        System.out.println(myName);
//        System.out.println(myAge);

        System.out.println(myConfigBean.getMyAge());
        System.out.println(myConfigBean.getMyName());

        return person;
    }

    private List<String> haha = new ArrayList<>();

    public static void main(String[] args) {
        MyController myController = new MyController();
        System.out.println(myController.haha == myController.haha());
    }

    public List<String> haha() {
        return this.haha;
    }
}
