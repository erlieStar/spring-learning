package com.javashitang.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultEchoService.class);
        enhancer.setInterfaces(new Class[] {EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
                Object result = methodProxy.invokeSuper(source, args);
                long cost = System.currentTimeMillis() - startTime;
                System.out.println("cost " + cost);
                return result;
            }
        });
        EchoService echoService = (EchoService) enhancer.create();
        System.out.println(echoService.echo("hello world"));
    }
}
