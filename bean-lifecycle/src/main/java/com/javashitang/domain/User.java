package com.javashitang.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author lilimin
 * @since 2021-03-10
 */
@Data
@ToString
public class User {

    private Long id;
    private String name;

    public User() {
        System.out.println("User 构造函数");
    }

}

