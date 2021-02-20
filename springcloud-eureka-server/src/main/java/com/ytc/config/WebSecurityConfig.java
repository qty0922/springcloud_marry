/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: WebSecurityConfig
 * Author:   15065
 * Date:     2021/2/20 17:28
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 〈Eureka注册中心开启密码认证〉<br>
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/20
 * @since 1.0.0
 */
@Configuration
//安全认证注解
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf  ——  跨站请求伪造
        http.csrf().disable();
        // 支持httpBasic
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
