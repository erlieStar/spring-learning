package com.javashitang.transactional;

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
public class AspectDefine {

    @Pointcut("execution(* com.javashitang.transactional.IndexService.index(..))")
    public void indexPointcut() {};

    @Before("indexPointcut()")
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @After("indexPointcut()")
    public void afterMethod() {
        System.out.println("afterMethod");
    }

}
