/**
 * @Copyright (C), 2015-2021, XXX有限公司
 * @FileName: TestController
 * @Author: qintianyu
 * @Date: 2021/3/2 15:26
 * @Description:
 * @Version: 1.0
 */
package com.ytc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description
 *
 * @author qintianyu
 * @create 2021/3/2
 * @since 1.0.0
 */
@RestController
public class TestController {

    public static Queue<String> queue = new LinkedBlockingDeque<>();

    @GetMapping("/addMsgs")
    public String addMsg(){
        queue.add("xxx");
        System.out.println("发："+queue.toString());
        return "success";
    }

    @GetMapping("/getMsg")
    public void getMsg(){
        System.out.println("出队："+queue.poll());
        System.out.println("收："+queue.toString());
    }


}
