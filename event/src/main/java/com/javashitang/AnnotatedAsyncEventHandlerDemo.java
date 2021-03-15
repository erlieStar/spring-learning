package com.javashitang;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lilimin
 * @since 2021-03-15
 */
@EnableAsync // 激活异步特性
public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedAsyncEventHandlerDemo.class);
        context.refresh();
        context.publishEvent(new MySpringEvent("hello world"));
        context.close();
    }

    @Async
    @EventListener
    public void onEvent(MySpringEvent event) {
        System.out.printf("my 线程 %s, 事件 %s", Thread.currentThread().getName(), event);
    }

    @Bean
    public Executor taskExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-event-thread-pool-"));
        return executorService;
    }

}
