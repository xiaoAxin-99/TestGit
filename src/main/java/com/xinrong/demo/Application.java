package com.xinrong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengxinrong
 * @version 1.0
 * @date 2019/11/24 2:49 上午
 */
@SpringBootApplication(scanBasePackages = "com.xinrong.demo")
@EnableTransactionManagement
@RestController
public class Application {



    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
