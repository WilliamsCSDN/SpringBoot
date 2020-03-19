package com.babt.stat.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param resp
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(e.getMessage(), e);
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
        	return "404";
        } else {
             return "500";
        }
    }
}