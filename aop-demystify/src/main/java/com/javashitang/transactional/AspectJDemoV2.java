package com.javashitang.transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemoV2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        // beforeMethod
        // cost 0
        // hello world
        System.out.println(demoService.index());
        context.close();
    }
}