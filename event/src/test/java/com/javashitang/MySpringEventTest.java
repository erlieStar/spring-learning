package com.javashitang;

import org.junit.Test;
import org.springframework.context.ApplicationListener;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-03-15
 */
public class MySpringEventTest {

    @Test
    public void test() {
        // class1.isAssignableFrom(class2) 
        // class1和class2所表示的类或接口是否相同
        // class1和class2所表示的类或接口是否相同
        System.out.println(ApplicationListener.class.isAssignableFrom(MySpringEventListener.class));
        System.out.println(MySpringEventListener.class.isAssignableFrom(MySpringEventListener.class));
    }

}