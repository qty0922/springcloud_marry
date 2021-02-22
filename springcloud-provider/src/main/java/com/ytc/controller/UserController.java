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

import com.netflix.discovery.EurekaClient;
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

    @Autowired
    private EurekaClient eurekaClient;

    /**
     * 获取客户端的一些配置信息
     * 无需再去调用eureka提供的REST API
     * @return
     */
    @GetMapping("/article/infos")
    public Object serviceUrl(){
        return eurekaClient.getInstancesByVipAddress("springcloud-provider",false);
    }

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
