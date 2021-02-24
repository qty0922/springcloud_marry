package com.ytc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudzuulApplication.class, args);
    }

}
