package com.javashitang.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class CostMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = invocation.proceed();
        long cost = System.currentTimeMillis() - startTime;
        System.out.println("cost " + cost);
        return result;
    }
}
