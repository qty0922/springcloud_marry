package com.ytc.dao;

import com.ytc.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper//扫描dao层包
public interface UserDao {

    List<User> queryUserList();

    void register(@RequestBody User user);
}
