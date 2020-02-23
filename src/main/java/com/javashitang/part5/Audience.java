package com.javashitang.part5;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    /*
     * 定义观众切面
     */
    @Pointcut("execution(** com.makenv.Performance.perform(..))")
    public void performance() {}

    //上面定义了performance就可以简写，否则得写成这样
    //@Before("execution(** Performance.perform(..))")
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("关掉手机");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("鼓掌");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("退票");
    }

}
