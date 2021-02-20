package com.ytc.service;

import com.ytc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserServiceApi {

    @GetMapping("queryUserList")
    List<User> queryUserList();

    @PostMapping("register")
    void register(@RequestBody User user);
}
