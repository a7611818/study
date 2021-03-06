package com.funtl.spring.cloud.alibaba.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable("str") String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);

    }

    @GetMapping("/echo2/{str}")
    public String echo2(@PathVariable("str") String str) {
        return restTemplate.getForObject("http://service-provider2/echo2/" + str, String.class);

    }


}
