package com.javashitang.aspect;

import com.javashitang.proxy.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class AspectJDemoV2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJConfig.class, AspectDefine.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUser());
        context.close();
    }
}