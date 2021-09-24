package com.javashitang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class CostInvocationHandler implements InvocationHandler {

    private Object target;

    public CostInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println("cost " + cost);
        return result;
    }
}
