package com.javashitang.manyOrder;

import com.javashitang.transactional.AspectJConfig;
import com.javashitang.transactional.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefineOne.class, AspectDefineTwo.class);
        IndexService indexService = context.getBean(IndexService.class);
        // beforeMethod
        // cost 0
        // hello world
        indexService.index();
        context.close();
    }
}