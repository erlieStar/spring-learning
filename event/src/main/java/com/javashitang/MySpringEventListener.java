package com.javashitang;

import org.springframework.context.ApplicationListener;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class MySpringEventListener implements ApplicationListener<MySpringEvent> {

    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("my 线程 %s, 事件 %s", Thread.currentThread().getName(), event);
    }
}
