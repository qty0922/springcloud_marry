/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: UserConfig
 * Author:   15065
 * Date:     2021/3/1 17:52
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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
//@ConfigurationProperties
public class UserConfig {

    /**
     * 使用的时候，需要自动注入：
     * @Autowired
     * private UserConfig userConfig;
     */
    @Value("${userName:zhangsan}")
    private String userName;

}
