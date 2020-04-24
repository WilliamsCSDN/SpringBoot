package com.dubbo.customer.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.util.calendar.LocalGregorianCalendar;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class TestAspect {
    private final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * com.dubbo.customer.controller..*.*(..))")

    public void controllerLog(){}

    @Before("controllerLog()")
    public void testBeforeController(JoinPoint joinPoint){
//        System.out.println("12345asdf****");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

//        logger.info("***********URL  : "+request.getRequestURL().toString());
//        logger.info("***********HTTP_METHOD : "+request.getMethod());
//        logger.info("***********IP: " +request.getRemoteAddr());
//        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
//        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
