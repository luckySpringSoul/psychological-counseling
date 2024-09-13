package com.rys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rys.db.mapper")
public class WebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUserApplication.class);
    }
}
