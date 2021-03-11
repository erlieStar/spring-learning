package com.javashitang.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author lilimin
 * @since 2021-03-11
 */
@Data
@ToString
public class Animal {

    private String name;
    private Long speed;

    public Animal() {
        System.out.println("Animal 构造函数");
    }
}
