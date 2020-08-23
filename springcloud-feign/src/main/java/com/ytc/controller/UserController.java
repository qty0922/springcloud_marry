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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2020/8/23
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("queryUserList")
    public String queryUserList(){
        List<User> list = userService.queryUserList();
        System.out.println(list);
        return "查询成功";
    }
}
