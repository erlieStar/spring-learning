package com.javashitang.importAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-10
 */
@EnableProxy
public class ImportAwareDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAwareDemo.class);
        ProxyMode bean = context.getBean(ProxyMode.class);
        // ProxyMode(mode=jdk)
        System.out.println(bean);
        context.close();
    }
}
