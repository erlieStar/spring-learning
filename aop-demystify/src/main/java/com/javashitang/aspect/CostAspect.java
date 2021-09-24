package com.javashitang.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lilimin
 * @since 2021-09-24
 */
@Aspect
public class CostAspect {

    @Pointcut("")
    public void costPointcutName() {}

    @Around("costPointcutName()")
    public Object calCost(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long cost = System.currentTimeMillis() - startTime;
        System.out.println("cost " + cost);
        return result;
    }
}
