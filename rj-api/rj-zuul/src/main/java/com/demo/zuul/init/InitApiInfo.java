/**
 * 
 */
package com.demo.zuul.init;

import com.demo.zuul.task.ApiServiceTask;
import com.demo.zuul.zuul.CustomRouteLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zhongqiu
 * @version $Id: InitApiInfo.java, v 0.1 2017年11月7日 下午7:25:51 zhongqiu Exp $
 */
@Component
@Order(value = 2)
public class InitApiInfo implements CommandLineRunner
{

    public final static Logger logger = LoggerFactory.getLogger(InitApiInfo.class);

    @Autowired
    ApiServiceTask apiServiceTask;

    @Autowired
    CustomRouteLocator routeLocator;

    @Override
    public void run(String... args) throws Exception {
        logger.warn("服务启动执行...");
        apiServiceTask.refreshServiceProviderList();
        routeLocator.refresh();
    }

}
