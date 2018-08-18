package com.demo.zuul.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 
 * @author zhongqiu
 * @version $Id: GatewayController.java, v 0.1 2017年11月7日 下午7:24:59 zhongqiu Exp $
 */
@RestController
public class GatewayController
{

    public final static Logger logger = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    ZuulHandlerMapping zuulHandlerMapping;

    @RequestMapping("/route")
    public String watchNowRoute() {
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        return JSON.toJSONString(handlerMap.keySet());
    }

}
