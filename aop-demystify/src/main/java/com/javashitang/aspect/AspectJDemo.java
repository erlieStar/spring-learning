package com.javashitang.aspect;

import com.javashitang.proxy.EchoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class);
        EchoService echoService = context.getBean(EchoService.class);
        System.out.println(echoService.echo("hello world"));
        context.close();
    }
}