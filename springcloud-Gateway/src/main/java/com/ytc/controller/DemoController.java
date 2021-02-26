/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: DemoController
 * Author:   15065
 * Date:     2021/2/26 10:34
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/26
 * @since 1.0.0
 */
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
