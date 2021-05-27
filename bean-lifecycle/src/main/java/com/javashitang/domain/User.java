package com.javashitang.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author lilimin
 * @since 2021-03-10
 */
@Data
@ToString
public class User implements BeanNameAware {

    @Resource
    private Animal animal;
    @Autowired
    private User user;

    private Long id;
    private String name;

    public User() {
        System.out.println("User 构造函数");
    }

    public void userInit() {
        System.out.println("user init");
    }

    public void userDestroy() {
        System.out.println("user destroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("User BeanNameAware");
        System.out.println("animal " + animal);
        System.out.println("user " + user);
    }

    @PostConstruct
    public void test() {
        System.out.println("user PostConstruct");
    }
}

