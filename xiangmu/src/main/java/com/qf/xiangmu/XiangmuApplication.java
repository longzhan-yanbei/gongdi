package com.qf.xiangmu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.qf.xiangmu.dao")
public class XiangmuApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiangmuApplication.class, args);
    }

}
