package com.javashitang.importAware;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lilimin
 * @since 2021-03-30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ProxyConfiguration.class)
public @interface EnableProxy {

    String mode() default "jdk";
}
