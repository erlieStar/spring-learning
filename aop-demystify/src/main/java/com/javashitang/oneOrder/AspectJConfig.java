package com.javashitang.oneOrder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public AddressService addressService() {
        return new AddressServiceImpl();
    }
}
