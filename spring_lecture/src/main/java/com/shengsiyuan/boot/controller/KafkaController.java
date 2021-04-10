package com.shengsiyuan.boot.controller;

import com.shengsiyuan.boot.kafka.KafkaMessage;
import com.shengsiyuan.boot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@RestController
@RequestMapping(value = "/kafka", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public KafkaMessage sendKafkaMessage(@RequestParam(name = "id") long id,
                                         @RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password
    ) {
        System.out.println("sendKafkaMessage invoked!");

        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(id);
        kafkaMessage.setUsername(username);
        kafkaMessage.setPassword(password);
        kafkaMessage.setDate(new Date());

        this.kafkaProducer.sendKafkaMessage(kafkaMessage);
        return kafkaMessage;
    }
}
