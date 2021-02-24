/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: DemoController
 * Author:   15065
 * Date:     2021/2/24 9:40
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/24
 * @since 1.0.0
 */
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello")
    public String callHello(){
        return restTemplate.getForObject("http://springcloud-provider/hello", String.class);
    }

    public String defaultCallHello() {
        return "不好意思，报错了！";
    }
}
