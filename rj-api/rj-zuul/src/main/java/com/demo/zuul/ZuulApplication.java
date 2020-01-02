package com.demo.zuul;

import com.demo.zuul.filter.AccessPostFilter;
import com.demo.zuul.filter.AccessPreFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.demo.zuul")
@EnableZuulProxy
@EnableDiscoveryClient
@MapperScan(basePackages = "com.demo.zuul.repositories")
public class ZuulApplication
{
    @Bean
    public AccessPreFilter accessPreFilter()
    {
        return new AccessPreFilter();
    }

    @Bean
    public AccessPostFilter accessPostFilter()
    {
        return new AccessPostFilter();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
