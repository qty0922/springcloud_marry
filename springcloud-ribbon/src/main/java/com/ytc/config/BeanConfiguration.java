/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: BeanConfiguration
 * Author:   15065
 * Date:     2021/2/22 14:54
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/22
 * @since 1.0.0
 */
@Configuration
public class BeanConfiguration {

    @Bean
    /**
     * 能够让 RestTemplate 具备负载均衡能力的注解
     * 修改接口调用的代码：
     *  将 IP+PORT 改成服务名称，也就是注册到 Eureka 中的名称
     */
    /**
     * @LoadBalanced 的原理：
     * 先给 RestTemplate 增加拦截器，在请求之前对请求的地址进行替换，
     * 或者根据具体的负载策略选择服务地址，然后再去调用。
     */
    @LoadBalanced
//    @MyLoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
