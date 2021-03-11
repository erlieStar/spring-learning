package com.javashitang.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lilimin
 * @since 2021-03-11
 */
@Data
@ToString
public class Student extends User implements InitializingBean, SmartInitializingSingleton, DisposableBean, BeanNameAware {

    private Long age;
    private String description;

    public Student() {
        System.out.println("Student 构造函数");
    }

    @PostConstruct
    public void postConstruct() {
        this.description = "v4";
        System.out.println(description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "v5";
        System.out.println(description);
    }

    public void customerInit() {
        this.description = "v6";
        System.out.println(description);
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.description = "v8";
        System.out.println(description);
    }

    @PreDestroy
    public void preDestroy() {
        this.description = "v10";
        System.out.println(description);
    }


    @Override
    public void destroy() throws Exception {
        this.description = "v11";
        System.out.println(description);
    }

    public void customerDestroy() {
        this.description = "v12";
        System.out.println(description);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }
}
