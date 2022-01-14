package com.javashitang.noCircular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2022-01-07
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        context.close();
    }
}
