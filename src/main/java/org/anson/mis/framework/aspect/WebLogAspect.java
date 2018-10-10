package org.anson.mis.framework.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 输出web请求及响应日志
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("execution(public * org.anson.mis.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("url : {}", request.getRequestURL().toString());
        logger.info("contentType : {}", request.getContentType());
        logger.info("ip : {}", request.getRemoteAddr());
        logger.info("controller_class_method : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("args : {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws JsonProcessingException {
        logger.info("response : {}", objectMapper.writeValueAsString(ret));
    }

    //后置异常通知

    @AfterThrowing("webLog()")
    public void doAfterThorwing(JoinPoint jp) throws JsonProcessingException {
        logger.error(objectMapper.writeValueAsString(jp));
    }
}
