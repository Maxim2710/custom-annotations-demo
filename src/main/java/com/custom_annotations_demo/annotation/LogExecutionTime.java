package com.custom_annotations_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 1. Аннотация LogExecutionTime - Логирует время выполнения метода.
 * Используется для мониторинга производительности.
 */
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
@Target(ElementType.METHOD) // Аннотация применяется только к методам
public @interface LogExecutionTime {
}
