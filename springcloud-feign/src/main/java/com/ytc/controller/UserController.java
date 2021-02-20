/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: userController
 * Author:   15065
 * Date:     2020/8/23 15:42
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.User;
import com.ytc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2020/8/23
 * @since 1.0.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("queryUserList")
    public String queryUserList(Model model){
        List<User> list = userService.queryUserList();
        model.addAttribute("list",list);
        System.out.println(list);
        return "user/show";
    }

    @PostMapping("register")
    public void register(User user){
        user.setUserId(2);
        user.setUserName("admin");
        user.setUserPwd("admin");
        userService.register(user);
        System.out.println("注册成功");
    }
}
