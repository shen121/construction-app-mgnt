package com.demo.mgnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ServletComponentScan({"com.demo.mgnt.config.filter"})
@EnableJms
public class MgntServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgntServiceApplication.class, args);
    }

}
