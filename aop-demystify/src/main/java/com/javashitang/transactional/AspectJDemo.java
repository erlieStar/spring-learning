package com.javashitang.transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefine.class);
        IndexService indexService = context.getBean(IndexService.class);
        // beforeMethod
        // cost 0
        // hello world
        System.out.println(indexService.index());
        context.close();
    }
}