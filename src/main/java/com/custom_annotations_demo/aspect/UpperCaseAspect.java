package com.custom_annotations_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpperCaseAspect {
    @Around("execution(* com.custom_annotations_demo.service.*.*(..))")
    public Object convertToUpper(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                args[i] = ((String) args[i]).toUpperCase();
            }
        }

        return joinPoint.proceed(args);
    }
}
