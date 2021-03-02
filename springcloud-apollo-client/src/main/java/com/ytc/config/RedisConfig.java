/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: RedisConfig
 * Author:   15065
 * Date:     2021/3/1 18:01
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/3/1
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "redis.cache")
public class RedisConfig {

    /**
     * 配置中心只需要增加 redis.cache.host 配置项即可实现注入，配置内容如下：
     * redis.cache.host = 192.168.1.28
     */
    private String host;
}
