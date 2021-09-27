package com.javashitang.invalid;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@Aspect
public class AspectDefine {

    @Pointcut("execution(* com.javashitang.invalid.SaveSevice.method2(..))")
    public void pointcutName() {}

    @Around("pointcutName()")
    public Object calCost(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启事务");
        return joinPoint.proceed();
    }
}
