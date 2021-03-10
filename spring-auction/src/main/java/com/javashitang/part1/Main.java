package com.javashitang.part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String names[] = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            // knight
            // weapon
            System.out.println(names[i]);
        }
        BraveKnight knight = context.getBean(BraveKnight.class);
        // knife
        System.out.println(knight.getWeapon().getType());
        context.close();
    }
}
