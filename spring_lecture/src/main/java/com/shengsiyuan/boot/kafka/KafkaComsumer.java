package com.shengsiyuan.boot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class KafkaComsumer {

    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("obtainMessage invoke!");

        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        int partition = consumerRecord.partition();
        long timestamp = consumerRecord.timestamp();
        System.out.println("topic: " + topic);
        System.out.println("key: " + key);
        System.out.println("partition: " + partition);
        System.out.println("timestamp: " + timestamp);
        System.out.println("---------------");
    }
}
