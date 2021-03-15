package com.javashitang;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.addApplicationListener(new MySpringEventListener());
        context.addApplicationListener((event) -> System.out.println("all 事件 " + event));
        context.refresh();
        context.publishEvent(new MySpringEvent("hello world"));
        context.publishEvent(new MySpringEvent("son"));
        context.close();
    }
}
