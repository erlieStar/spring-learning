package com.javashitang.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String names[] = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            // myConfig
            // braveKnight
            // weapon
            System.out.println(names[i]);
        }
        BraveKnight knight = context.getBean(BraveKnight.class);
//        BraveKnight knight = SpringHelper.getBean(BraveKnight.class);
        // knife
        System.out.println(knight.getWeapon().getClassC().getName());
        context.close();
    }
}
