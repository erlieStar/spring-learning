package com.javashitang.dependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2022-01-07
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean(A.class).getB() == context.getBean(B.class));
        System.out.println(context.getBean(B.class).getA() == context.getBean(A.class));
    }
}
