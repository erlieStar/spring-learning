package com.javashitang.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public CarService userService() {
        return new CarServiceImpl();
    }
}
