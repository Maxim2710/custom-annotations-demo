package com.custom_annotations_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 6. Аннотация RetryOperation - Повторяет выполнение метода в случае ошибки.
 */
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
@Target(ElementType.METHOD) // Аннотация применяется к методам
public @interface RetryOperation {
    int attempts() default 3; // Количество попыток
}
