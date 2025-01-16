package com.custom_annotations_demo.aspect;

import com.custom_annotations_demo.annotation.ValidateNotNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateNotNullAspect {
    @Before("execution(* com.custom_annotations_demo.service.*.*(..)) && args(param)")
    public void checkNotNull(JoinPoint joinPoint, @ValidateNotNull Object param) {
        if (param == null) {
            throw new IllegalArgumentException("Параметр не может быть null: " +
                    joinPoint.getSignature().getName());
        }
    }
}
