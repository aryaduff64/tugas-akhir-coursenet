package com.subrutin.catalog.aspect;

import com.subrutin.catalog.dto.BookDetailResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.subrutin.catalog.web.*.*(..))")
    private void restAPI() {}

    @Pointcut("within(com.subrutin.catalog.web.*)")
    private void withinPointcutExample() {}

    @Pointcut("args(com.subrutin.catalog.dto.PublisherCreateRequestDTO)")
    private void argsPointcutExample() {}

    @Pointcut("@args(com.subrutin.catalog.annotation.LogThisArg)")
    private void argsAnnotationPointcutExample() {}

    @Pointcut("@annotation(com.subrutin.catalog.annotation.LogThisMethod)")
    private void annotationPointcutExample() {}

    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect before method executed");
    }

    @After("annotationPointcutExample()")
    public void afterExecutedLogging() {
        log.info("this is log from aspect after method executed");
    }

    @AfterReturning("annotationPointcutExample()")
    public void afterReturnExecutedLogging() {
        log.info("this is log from aspect after returning method executed");
    }

    @AfterThrowing("annotationPointcutExample()")
    public void afterThrowingExecutedLogging() {
        log.info("this is log from aspect after throwing method executed");
    }

    @Around("restAPI()")
    public Object processingTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();


        try {
            log.info("start {}.{} ",joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName());
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("finish {}.{} execution time = {}",joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());
        }
    }

}
