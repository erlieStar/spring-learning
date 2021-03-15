package com.javashitang;

import org.springframework.context.ApplicationEvent;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class MySpringEvent extends ApplicationEvent {

    public MySpringEvent(Object source) {
        super(source);
    }
}
