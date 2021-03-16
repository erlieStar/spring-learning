package com.javashitang;

import com.javashitang.domain.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-16
 */
public class BeanFactoryDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        String[] locations = {"bean-factory-context.xml"};
        applicationContext.setConfigLocations(locations);
        applicationContext.refresh();

        Animal animal1 = applicationContext.getBean("animal", Animal.class);
        Animal animal2 = applicationContext.getBean("animal", Animal.class);
        System.out.println(animal1 == animal2);

        applicationContext.close();

    }
}
