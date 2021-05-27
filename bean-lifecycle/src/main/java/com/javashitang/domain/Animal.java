package com.javashitang.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.Resource;

/**
 * @author lilimin
 * @since 2021-03-11
 */
@Data
@ToString
public class Animal implements BeanNameAware {

    @Resource
    private User user;

    private String name;
    private Long speed;

    public Animal() {
        System.out.println("Animal 构造函数");
    }

    public void customerInit() {
        System.out.println("animal init");
    }

    public void customerDestroy() {
        System.out.println("animal destroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Animal BeanNameAware");
    }
}
