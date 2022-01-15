package com.javashitang.destroyV2;

import javax.annotation.PreDestroy;

/**
 * @author lilimin
 * @since 2022-01-14
 */
public class TestDestroy {

    @PreDestroy
    public void preDestroy() {
        System.out.println("阶段1");
    }
}
