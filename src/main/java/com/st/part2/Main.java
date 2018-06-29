package com.st.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();
//        BraveKnight knight = context.getBean(BraveKnight.class);
        BraveKnight knight = SpringHelper.getBean(BraveKnight.class);
        // knife
        System.out.println(knight.getWeapon().getClassC().getName());
        context.close();
    }
}
