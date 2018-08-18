package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

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
