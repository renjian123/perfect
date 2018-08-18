/**
 *
 */
package com.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhongqiu
 * @version $Id: AccessPreFilter.java, v 0.1 2017年11月7日 下午7:25:40 zhongqiu Exp $
 * <p>
 * http://hdp1.bbd.com:8081/greatwall/monitor?appkey=34246183791146ad82fa7b0ba8cd108c
 */
public class AccessPreFilter extends ZuulFilter
{
    @Override
    public String filterType()
    {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return 1;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run()
    {
        System.out.println("我是前置过滤器，我发生在路由之前");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURI();
        if (url.contains("xxx"))
        {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }
        return null;
    }
}
