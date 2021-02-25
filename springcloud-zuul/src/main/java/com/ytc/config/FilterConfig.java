/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FilterConfig
 * Author:   15065
 * Date:     2021/2/24 15:40
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import com.ytc.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/24
 * @since 1.0.0
 */
@Configuration
public class FilterConfig {

    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }

    @Bean
    public MyFilter1 myFilter1(){
        return new MyFilter1();
    }

    @Bean
    public MyFilter2 myFilter2(){
        return new MyFilter2();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }
}
