/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FeignConfiguration
 * Author:   15065
 * Date:     2021/2/23 15:43
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
@Configuration
public class FeignConfiguration {
    /**
     * 日志级别：4种
     * NONE：不输出日志。
     * BASIC：只输出请求方法的 URL 和响应的状态码以及接口执行的时间。
     * HEADERS：将 BASIC 信息和请求头信息输出。
     * FULL：输出完整的请求信息。
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 契约配置：
     *
     * Spring Cloud 在 Feign 的基础上做了扩展，
     * 可以让 Feign 支持 Spring MVC 的注解来调用。
     * 原生的 Feign 是不支持 Spring MVC 注解的
     * @return
     */
    /*@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }*/

    /**
     * Basic 认证配置
     *
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}
