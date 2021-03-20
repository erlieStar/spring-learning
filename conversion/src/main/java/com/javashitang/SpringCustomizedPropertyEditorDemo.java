package com.javashitang;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-20
 */
public class SpringCustomizedPropertyEditorDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("property-editors-context.xml");
        User user = context.getBean("user", User.class);
        // User(id=1, name=小马哥, context={name=xiaoshi, id=1})
        System.out.println(user);
        context.close();
    }
}
