package com.st.part1;

import com.st.part1.BraveKnight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BraveKnight knight = context.getBean(BraveKnight.class);
        // knife
        System.out.println(knight.getWeapon().getType());
        context.close();
    }
}
