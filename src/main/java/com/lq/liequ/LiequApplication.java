package com.lq.liequ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.lq.liequ.dao")
@EnableSwagger2 // 启用swagger 生成接口描述
public class LiequApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LiequApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LiequApplication.class);
    }
}
