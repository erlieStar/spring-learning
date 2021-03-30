package com.javashitang;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-10
 */
@EnableHelloWorld
public class EnableModuleDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnableModuleDemo.class);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
