package com.funtl.hello.spring.boot;

import com.funtl.hello.spring.boot.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@SpringBootTest
class HelloSpringBootApplicationTests {
    @Autowired
    HelloController helloController;

    @Test
    void contextLoads() {
        List<String> sourceList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sourceList.add("第" + i + "条数据");
        }

        sourceList.stream().forEach(t -> doSome());

    }

    private void doSome() {
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test02() throws InterruptedException {
        while (true) {
            Thread.sleep(1111);
            new Thread(() -> {
                try {
                    Thread.sleep(1111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId());
            }).start();
        }
    }
}