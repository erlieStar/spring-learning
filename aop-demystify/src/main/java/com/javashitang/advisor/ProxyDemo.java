package com.javashitang.advisor;

import com.javashitang.proxy.EchoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class ProxyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyConfig.class);
        EchoService echoService = (EchoService) context.getBean("echoProxy");
        // cost 0
        // hello world
        System.out.println(echoService.echo("hello world"));
    }
}
