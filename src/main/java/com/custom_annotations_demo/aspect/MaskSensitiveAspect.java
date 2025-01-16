package com.custom_annotations_demo.aspect;

import com.custom_annotations_demo.annotation.MaskSensitive;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class MaskSensitiveAspect {
    @Around("execution(* com.custom_annotations_demo.service.*.toString(..))")
    public Object maskSensitiveFields(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        for (Field field : result.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaskSensitive.class)) {
                field.setAccessible(true);
                field.set(result, "****");
            }
        }

        return result;
    }
}
