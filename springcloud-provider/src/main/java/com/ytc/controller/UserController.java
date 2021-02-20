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

import com.ytc.dao.UserDao;
import com.ytc.model.User;
import com.ytc.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserController implements UserServiceApi {

    @Autowired
    private UserDao userDao;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("queryUserList")
    public List<User> queryUserList(){
        List<User> list = userDao.queryUserList();
        return list;
    }

    @PostMapping("register")
    public void register(@RequestBody User user){
        userDao.register(user);
        System.out.println("注册成功");
    }
}
