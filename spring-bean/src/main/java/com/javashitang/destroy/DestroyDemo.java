package com.javashitang.destroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilimin
 * @since 2022-01-14
 */
@Configuration
public class DestroyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DestroyDemo.class);
        applicationContext.close();
    }


    @Bean(destroyMethod = "customerDestroy")
    public TestDestroy demo() {
        return new TestDestroy();
    }
}
