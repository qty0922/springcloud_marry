package com.ytc.service;

import com.ytc.config.FeignConfiguration;
import com.ytc.config.UserRemoteClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

//定义需要调用哪个接口的服务名   ——————   指明配置类（输出feign的日志） ————————fallback：指明熔断器回退的错误类
@FeignClient(value = "springcloud-provider",configuration = FeignConfiguration.class,fallback = UserRemoteClientFallback.class)
public interface UserService extends UserServiceApi{

}
