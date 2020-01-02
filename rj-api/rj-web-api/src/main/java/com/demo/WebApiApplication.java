package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "com.demo")
@EnableDiscoveryClient
@MapperScan("com.demo.dao")
public class WebApiApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(WebApiApplication.class, args);
    }
}
