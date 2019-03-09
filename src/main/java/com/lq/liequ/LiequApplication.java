package com.lq.liequ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lq.liequ.dao")
public class LiequApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiequApplication.class, args);
    }

}
