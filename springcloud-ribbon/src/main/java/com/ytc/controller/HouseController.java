/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: HouseController
 * Author:   15065
 * Date:     2021/2/23 9:10
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.HouseInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
@RestController
public class HouseController {

    @GetMapping("/house/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        System.out.println("调用getData方法");
        return new HouseInfo(1, "上海—虹口—东体小区");
    }

    @GetMapping("/house/data/{name}")
    public String getData2(@PathVariable(value = "name") String name) {
        System.out.println("调用getData2方法");
        return name;
    }

}
