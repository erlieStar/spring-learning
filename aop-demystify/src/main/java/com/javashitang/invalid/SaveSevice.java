package com.javashitang.invalid;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author lilimin
 * @since 2021-09-27
 */
@Service
public class SaveSevice {

    public void method1() {
        System.out.println("method1 executed");
        ((SaveSevice) AopContext.currentProxy()).method2();
    }

    public void method2() {
        System.out.println("method2 executed");
    }
}
