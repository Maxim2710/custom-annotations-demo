package com.custom_annotations_demo.aspect;

import com.custom_annotations_demo.annotation.DefaultValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class DefaultValueAspect {
    @Around("execution(* com.custom_annotations_demo.service.*.*(..))")
    public Object applyDefaultValue(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();

        for (int i = 0; i < args.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (annotation instanceof DefaultValue && args[i] == null) {
                    args[i] = ((DefaultValue) annotation).value();
                }
            }
        }

        return joinPoint.proceed(args);
    }
}
