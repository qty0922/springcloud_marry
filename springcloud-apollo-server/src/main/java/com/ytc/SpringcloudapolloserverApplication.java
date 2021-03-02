package com.ytc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcloudapolloserverApplication {

    public static void main(String[] args) {
        // 指定环境(仅供开发演示用, 不能用于生产环境))
        System.setProperty("env", "DEV");
        SpringApplication.run(SpringcloudapolloserverApplication.class, args);
    }

}
