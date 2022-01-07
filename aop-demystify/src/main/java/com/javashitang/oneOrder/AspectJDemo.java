package com.javashitang.oneOrder;

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
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefine.class);
        IndexService indexService = context.getBean(IndexService.class);
        indexService.index();
        context.close();
    }
}