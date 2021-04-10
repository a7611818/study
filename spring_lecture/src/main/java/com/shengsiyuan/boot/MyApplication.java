package com.shengsiyuan.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;


/**
 * @author ybq
 */
@SpringBootApplication
public class MyApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        String[] names = SpringApplication.run(MyApplication.class, args).getBeanNamesForType(String.class);
        System.out.println(Arrays.toString(names));
    }

    @PostConstruct
    public void myLog() {
        logger.trace("Trace Message");
        logger.debug("Debug Message");
        logger.info("Info Message");
        logger.warn("Warn Message");
        logger.error("Error Message");
    }
}