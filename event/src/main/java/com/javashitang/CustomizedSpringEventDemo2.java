package com.javashitang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class CustomizedSpringEventDemo2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/event-context.xml");
        context.refresh();
        context.publishEvent(new MySpringEvent("hello world"));
        context.close();
    }
}
