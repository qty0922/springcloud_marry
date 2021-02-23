/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyLoadBalancerInterceptor
 * Author:   15065
 * Date:     2021/2/23 14:17
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.interceptor;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URI;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {

    //负载均衡客户端
    private LoadBalancerClient loadBalancer;
    //负载均衡请求工厂
    private LoadBalancerRequestFactory requestFactory;

    /**
     * 提供构造器
     * @param loadBalancer
     * @param requestFactory
     */
    public MyLoadBalancerInterceptor(LoadBalancerClient loadBalancer, LoadBalancerRequestFactory requestFactory) {
        this.loadBalancer = loadBalancer;
        this.requestFactory = requestFactory;
    }

    public MyLoadBalancerInterceptor(LoadBalancerClient loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public MyLoadBalancerInterceptor() {
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        final URI originalUri = request.getURI();
        String serviceName = originalUri.getHost();
        System.out.println("进入自定义的请求拦截器中" + serviceName);
        Assert.state(serviceName != null, "Request URI does not contain a valid hostname: " + originalUri);
        return this.loadBalancer.execute(serviceName, requestFactory.createRequest(request, body, execution));
    }
}
