package com.javashitang.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@Aspect
public class AspectDefine {

    @Pointcut("execution(* com.javashitang.simple.CarService.getCar(..))")
    public void carPointcut() {};

    @Before("carPointcut()")
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @Around("carPointcut()")
    public Object calCost(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long cost = System.currentTimeMillis() - startTime;
        System.out.println("cost " + cost);
        return result;
    }

    @After("carPointcut()")
    public void afterMethod() {
        System.out.println("afterMethod");
    }
}
