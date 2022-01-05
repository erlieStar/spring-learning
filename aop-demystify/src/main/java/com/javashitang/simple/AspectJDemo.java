package com.javashitang.simple;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefine.class);
        CarService carService = context.getBean(CarService.class);
        // beforeMethod
        // cost 0
        // hello world
        System.out.println(carService.getCar());
        context.close();
    }
}