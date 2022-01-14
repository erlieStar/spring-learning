package com.javashitang.destroy;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @author lilimin
 * @since 2022-01-14
 */
public class TestDestroy implements DisposableBean {

    @PreDestroy
    public void preDestroy() {
        System.out.println("阶段1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("阶段2");
    }

    public void customerDestroy() {
        System.out.println("阶段3");
    }

}
