package com.javashitang.oneOrder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @Pointcut("execution(* com.javashitang.oneOrder.AddressService.address(..))")
    public void a() {};

    @Before("a()")
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @Around("a()")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aroundMethod");
        joinPoint.proceed();
    }

    @After("a()")
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @AfterReturning("a()")
    public void afterReturningMethod() {
        System.out.println("afterReturningMethod");
    }

    @AfterThrowing("a()")
    public void afterThrowingMethod() {
        System.out.println("afterThrowingMethod");
    }


}
