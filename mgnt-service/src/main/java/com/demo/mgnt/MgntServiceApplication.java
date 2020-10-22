package com.demo.mgnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan({"com.demo.mgnt.config.filter"})
public class MgntServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgntServiceApplication.class, args);
    }

}
