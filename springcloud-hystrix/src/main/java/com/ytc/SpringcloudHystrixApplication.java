package com.ytc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//注意：@EnableHystrix 中包含了 @EnableCircuitBreaker。
@EnableHystrix
//@EnableCircuitBreaker
public class SpringcloudHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
