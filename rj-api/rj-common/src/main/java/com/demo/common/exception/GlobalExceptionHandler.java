package com.demo.common.exception;

import com.demo.common.param.Result;
import com.demo.common.param.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Autowired
    ErrorMessageSourceHandler  messageSourceHandler;

    public final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 所有异常报错
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> allExceptionHandler(Exception e) throws Exception {
        logger.error("", e);
        if (e instanceof GlobleException) {
            GlobleException ge = (GlobleException) e;
            String code = ge.getErrorCode();
            String message = messageSourceHandler.getMessage(code, ge.getArgs());
            int responseCode = ge.getResponseCode();
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            response.setStatus(responseCode);
            return ResultBuilder.aResult().withCode(401).withMessage(message).build();
        }
        String message = messageSourceHandler.getMessage(ErrorCodeConstants.COMMON_SERVER_10001, null);
        return ResultBuilder.aResult().withCode(401).withMessage(message).build();
    }

}