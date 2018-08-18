package com.demo.common.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.demo.common.interceptor.LogInterceptor;
import org.apache.commons.lang.StringUtils;

public class RequestIdConverter extends ClassicConverter {


    @Override
    public String convert(ILoggingEvent event) {
        String requestId = LogInterceptor.requestIds.get();

        if(StringUtils.isBlank(requestId)){
            return "reqId-000000";
        }


        return requestId;
    }
}

