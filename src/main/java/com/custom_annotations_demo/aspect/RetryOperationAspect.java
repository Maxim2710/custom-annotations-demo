package com.custom_annotations_demo.aspect;

import com.custom_annotations_demo.annotation.RetryOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryOperationAspect {
    @Around("@annotation(retryOperation)")
    public Object retry(ProceedingJoinPoint joinPoint, RetryOperation retryOperation) throws Throwable {
        int attempts = retryOperation.attempts();
        Throwable exception = null;

        for (int i = 0; i < attempts; i++) {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                exception = e;
            }
        }

        assert exception != null;
        throw exception;
    }
}
