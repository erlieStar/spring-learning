package com.javashitang;

import com.javashitang.domain.Animal;
import com.javashitang.domain.Student;
import com.javashitang.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lilimin
 * @since 2021-03-11
 */
public class BeanLifecycleDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        String[] locations = {"bean-lifecycle-context.xml"};
        applicationContext.setConfigLocations(locations);
        applicationContext.refresh();

        Animal animal = applicationContext.getBean("animal", Animal.class);
        System.out.println(animal);

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);

        applicationContext.close();

    }
}
