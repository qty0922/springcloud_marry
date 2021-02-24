/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyFilter1
 * Author:   15065
 * Date:     2021/2/24 16:21
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/24
 * @since 1.0.0
 */
public class MyFilter1 extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.set("msg","你好吗？");

        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");

        if (token==null){
            //过滤该请求不对其路由
            context.setSendZuulResponse(false);
            //返回错误码
            context.setResponseStatusCode(401);
            //或者设置相应信息
            try {
                context.getResponse().getWriter().write("token is err");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        return null;
    }
}
