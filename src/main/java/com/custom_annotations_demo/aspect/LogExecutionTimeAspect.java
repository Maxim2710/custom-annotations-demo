package com.custom_annotations_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around(("@annotation(com.custom_annotations_demo.annotation.LogExecutionTime)"))
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // выполнение метода
        long duration = System.currentTimeMillis() - start;

        logger.info("Метод {} выполнен за {} мс", joinPoint.getSignature(), duration); // Логируем информацию о времени выполнения
        return result;
    }
}
