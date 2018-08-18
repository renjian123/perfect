/**
 * 
 */
package com.demo.zuul.task;

import com.demo.common.bean.ServiceProvider;
import com.demo.zuul.repositories.RefreshRouteRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author zhongqiu
 * @version $Id: ApiServiceTask.java, v 0.1 2017年11月7日 下午7:26:31 zhongqiu Exp $
 */
@Component
public class ApiServiceTask
{

    public final static Logger                 logger     = LoggerFactory.getLogger(ApiServiceTask.class);

    public final static Map<String, ZuulRoute> serviceMap = new ConcurrentHashMap<String, ZuulRoute>();

    @Autowired
    private RefreshRouteRepository repository;

    public static void refreshServiceMap(final Map<String, ZuulRoute> newMap) {
        synchronized (serviceMap) {
            if (newMap != null) {
                serviceMap.clear();
                serviceMap.putAll(newMap);
                logger.warn("ApiServiceTask.refreshServiceMap:{}", serviceMap);
            }
        }
    }

    public static Map<String, ZuulRoute> getServiceMap() {
        /* 同步，避免refresh过程中获取到不完整信息 */
        synchronized (serviceMap) {
            return serviceMap;
        }
    }

    /**
     * 这个定时任务通过http请求后端服务获取服务列表是为了解决：之前将这部分逻辑放入com.bbd.spider.dataplatform.gateway.zuul.CustomRouteLocator
     * 中产生的FeignClient与Zuul本身初始化，由于声明周期冲突，导致的循环依赖问题
     * 
     * 定时刷新serviceMap，CustomRouteLocator中访问该map的服务信息
     */
    @Scheduled(cron = "0 0/2 * * * ?")
    public void refreshServiceProviderList() {
        List<ServiceProvider> list = repository.getApiServiceProviderList();
        if (list != null && list.size() > 0) {
            Map<String, ZuulRoute> tempMap = new LinkedHashMap<String, ZuulRoute>();
            for (ServiceProvider bean : list) {
                if (StringUtils.isBlank(bean.getPath()) || StringUtils.isBlank(bean.getServiceId()) || bean.getEnabled() == 0) {
                    continue;
                }

                ZuulRoute zuulRoute = new ZuulRoute();
                try {
                    copyProperties(bean, zuulRoute);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                tempMap.put(zuulRoute.getPath(), zuulRoute);
            }
            refreshServiceMap(tempMap);
        }
    }

    public String getValidatePath(String path) {
        if (path != null) {
            path = path.trim();
            if (!path.endsWith("/")) {
                path = path + "/";
            }
            path = path + "**";
        }
        return path;
    }

    public void copyProperties(ServiceProvider from, ZuulRoute to) {
        to.setId(from.getId());
        to.setPath(getValidatePath(from.getPath()));
        to.setRetryable(from.getRetryAble() == 0 ? false : true);
        to.setServiceId(from.getServiceId());
        to.setStripPrefix(from.getStripPrefix() == 0 ? false : true);
        to.setUrl(from.getUrl());
    }

}
