package com.st.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();
        BraveKnight knight = context.getBean(BraveKnight.class);
        // knife
        System.out.println(knight.getWeapon().getType());
        context.close();
    }
}
