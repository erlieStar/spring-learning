package com.javashitang.aspectjPointcut.annotationDemo;

import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author lilimin
 * @since 2021-09-27
 */
@java.lang.annotation.Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface Log {
}
