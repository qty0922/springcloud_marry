/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: PostFilter
 * Author:   15065
 * Date:     2021/2/25 9:56
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/25
 * @since 1.0.0
 */
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        System.err.println("Request："+request.getScheme()+"\t"+request.getRemoteAddr()+":"+request.getRemotePort());
        StringBuilder params = new StringBuilder("?");
        //获取URL参数
        Enumeration<String> names = request.getParameterNames();
        if (request.getMethod().equals("GET")){
            //测试此枚举是否包含更多的元素
            while (names.hasMoreElements()){
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
        }
        if (params.length()>0) {
            params.delete(params.length()-1,params.length());
        }
        System.err.println("Request:>"+request.getMethod()+"\t"+request.getRequestURI()+"\t"+request.getProtocol());
        //获取HTTP报文的头部信息
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String name = headers.nextElement();
            String value = request.getHeader(name);
            System.err.println("Request:>"+name+"\t"+value);
        }
        //获取请求参数
        final RequestContext context = RequestContext.getCurrentContext();
        if (!context.isChunkedRequestBody()){
            ServletInputStream stream = null;
            try {
                stream = context.getRequest().getInputStream();
                String body = null;
                if(stream!=null){
                    body = IOUtils.toString(stream);
                    System.err.println("Request:>"+body);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return null;
    }
}
