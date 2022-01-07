package com.javashitang.dependency;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lilimin
 * @since 2022-01-07
 */
@Data
@Component
public class A {

    @Autowired
    private B b;
}
