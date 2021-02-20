package com.ytc.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider")
public interface UserService extends UserServiceApi{

}
