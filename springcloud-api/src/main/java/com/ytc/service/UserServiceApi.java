package com.ytc.service;

import com.ytc.model.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserServiceApi {

    @GetMapping("queryUserList")
    List<User> queryUserList();
}
