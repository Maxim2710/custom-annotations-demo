package com.custom_annotations_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 3. Аннотация DefaultValue - Позволяет устанавливать значение по умолчанию, если параметр метода равен null.
 */
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
@Target(ElementType.PARAMETER) // Аннотация применяется к параметрам метода
public @interface DefaultValue {
    String value();
}
