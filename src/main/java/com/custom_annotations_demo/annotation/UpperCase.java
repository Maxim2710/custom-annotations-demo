package com.custom_annotations_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 5. Аннотация UpperCase - Приводит строковые параметры метода к верхнему регистру.
 */
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
@Target(ElementType.PARAMETER) // Аннотация применяется к параметрам метода
public @interface UpperCase {
}
