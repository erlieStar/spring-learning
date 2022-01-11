package com.javashitang.oneOrder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefine.class);
        AddressService addressService = context.getBean(AddressService.class);
        addressService.address();
        context.close();
    }
}