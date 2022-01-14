package com.javashitang.noCircular;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2022-01-07
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.javashitang.noCircular")
public class Config {
}
