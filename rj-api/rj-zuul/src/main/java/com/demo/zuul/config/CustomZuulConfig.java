package com.demo.zuul.config;

import com.demo.zuul.repositories.RefreshRouteRepository;
import com.demo.zuul.zuul.CustomRouteLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(RefreshRouteRepository.class)
public class CustomZuulConfig
{
    public final static Logger logger                    = LoggerFactory.getLogger(CustomZuulConfig.class);

    public static final String KEY_REQUEST_RESOURCE_TYPE = "requestResourceType";

    @Autowired
    ZuulProperties zuulProperties;
    @Autowired
    ServerProperties server;

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
        return routeLocator;
    }
}
