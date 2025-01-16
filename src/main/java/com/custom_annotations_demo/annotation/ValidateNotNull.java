package com.custom_annotations_demo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 2. Аннотация ValidateNotNull - Запрещает передавать null в аргументы метода.
 * Если передан null, выбрасывается исключение IllegalArgumentException.
 */
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
@Target(ElementType.PARAMETER) // Аннотация применяется к параметрам метода
public @interface ValidateNotNull {
}
