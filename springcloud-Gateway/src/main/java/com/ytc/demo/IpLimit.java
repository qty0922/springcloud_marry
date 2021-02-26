/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: IpLimit
 * Author:   15065
 * Date:     2021/2/26 9:22
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.demo;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/26
 * @since 1.0.0
 */
@Component
public class IpLimit {

    /**
     * KeyResolver是KeyResolverSpi子类的工厂类，这些子类表示KeyInfo的子元素。
     * @return 注册的解析器的长度
     */
    @Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    public static String getIpAddr(ServletServerHttpRequest request){
        HttpHeaders headers = request.getHeaders();
        List<String> ips = headers.get("X-Forwarded-For");
        String ip = "192.168.1.28";
        if (ips!=null && ips.size()>0){
            ip = ips.get(0);
        }
        System.out.println(ip);
        return ip;
    }
}
