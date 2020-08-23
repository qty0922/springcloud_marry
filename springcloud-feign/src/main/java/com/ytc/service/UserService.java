package com.ytc.service;

import com.ytc.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "springcloud-provider")
public interface UserService extends UserServiceApi{

}
