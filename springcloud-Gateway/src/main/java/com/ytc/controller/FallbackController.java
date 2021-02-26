/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FallbackController
 * Author:   15065
 * Date:     2021/2/26 11:15
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/26
 * @since 1.0.0
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Map<String,String> fallback(){
        Map<String,String> map = new HashMap<>();
        map.put("msg","网络繁忙服务降级请稍后再访问");
        map.put("code","GW0001");
        return map;
    }
}
