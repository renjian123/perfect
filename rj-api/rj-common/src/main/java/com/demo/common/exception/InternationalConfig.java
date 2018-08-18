package com.demo.common.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 国际化设置
 */
@Configuration
public class InternationalConfig
{
    @Value(value = "${spring.messages.basename}")
    private String basename = "messages.properties";

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getMessageResource() throws IOException
    {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(basename);
        Properties properties = System.getProperties();
        properties.load(inputStream);
        messageSource.setCommonMessages(properties);
        return messageSource;
    }

}