/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: IpFilter
 * Author:   15065
 * Date:     2021/2/24 15:17
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.ytc.util.IpUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/24
 * @since 1.0.0
 */
public class IpFilter extends ZuulFilter {

    // IP黑名单列表
    private List<String> blackIpList = Arrays.asList("192.168.1.28");

    //构造方法
    public IpFilter() {
        super();
    }

    /**
     *filterType为过滤器类型，它决定过滤器在哪个生命周期中执行
     *  pre：路由之前
     *  routing：路由之时
     *  post： routing，pre之后
     *  error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序
     * 在同一个阶段存在多个过滤器时，按照返回的值的顺序执行
     * 越小越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行
     * 实际项目中我们可以在这里写逻辑判断该过滤器是否需要被执行
     * true：执行 false：不执行
     * 这里我们设置true直接全部请求必须执行过滤器
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String ip = IpUtils.getIpAddr(context.getRequest());
//        System.out.println(2/0);
//        System.out.println(ip);
        // 在黑名单中禁用
        if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)) {
            //过滤该请求不对其路由
            context.setSendZuulResponse(false);
            //返回错误码
            context.setResponseStatusCode(401);
            //或者设置相应信息
            try {
                HttpServletResponse response = context.getResponse();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("ip:"+ip+"已被封禁！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
