package com.javashitang.order;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@Order(1)
@Aspect
public class AspectDefineOne {

    @Pointcut("execution(* com.javashitang.transactional.IndexService.index(..))")
    public void a() {};

    @Before("a()")
    public void beforeMethod() {
        System.out.println("a beforeMethod");
    }

    @After("a()")
    public void afterMethod() {
        System.out.println("a afterMethod");
    }

}
