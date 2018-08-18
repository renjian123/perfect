package com.demo.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化操作相关
 */
@Component
public class ErrorMessageSourceHandler {

    @Autowired
    private MessageSource messageSource;

    /**
     * @param messageKey
     * @return
     */
    public String getMessage(String messageKey, Object[] args) {
        String message = messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
        return message;
    }
}