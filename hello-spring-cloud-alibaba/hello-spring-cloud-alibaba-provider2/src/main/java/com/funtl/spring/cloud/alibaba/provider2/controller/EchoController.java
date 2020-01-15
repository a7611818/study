package com.funtl.spring.cloud.alibaba.provider2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping(value = "/echo2/{string}")
    public String echo(@PathVariable("string") String string) {
        return "Hello Nacos Provider2 " + string;
    }
}
