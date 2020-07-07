package com.clfeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.clfeng.mapper")
public class SpringbootMybatisplusRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusRedisApplication.class, args);
    }

}
