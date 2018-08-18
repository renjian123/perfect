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
public class AccessPostFilter extends ZuulFilter
{
    @Override
    public String filterType()
    {
        return FilterConstants.POST_TYPE;
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
        System.out.println("我是后置过滤器，我发生在路由之前");
        return null;
    }
}
