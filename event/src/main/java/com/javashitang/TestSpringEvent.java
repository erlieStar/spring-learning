package com.javashitang;

import org.springframework.context.ApplicationEvent;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class TestSpringEvent extends ApplicationEvent {

    public TestSpringEvent(Object source) {
        super(source);
    }
}
