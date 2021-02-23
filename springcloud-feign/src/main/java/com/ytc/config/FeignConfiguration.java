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
}
