package com.javashitang.proxy;

import java.lang.reflect.Proxy;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader,
                new Class[]{EchoService.class},
                new CostInvocationHandler(new DefaultEchoService()));
        EchoService echoService = (EchoService) proxy;
        // cost 0
        // hello world
        System.out.println(echoService.echo("hello world"));
    }
}
