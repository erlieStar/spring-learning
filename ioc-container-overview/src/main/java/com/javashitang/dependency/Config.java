package com.javashitang.dependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2022-01-07
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.javashitang.dependency")
public class Config {
}
