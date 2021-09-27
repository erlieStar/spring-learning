package com.javashitang.invalid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-27
 */
@EnableAspectJAutoProxy
public class InvalidDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SaveSevice.class,
                        AspectDefine.class, InvalidDemo.class);
        SaveSevice saveSevice = context.getBean(SaveSevice.class);
        saveSevice.method1();
        System.out.println("--");
        saveSevice.method2();
    }
}
