package com.javashitang.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author lilimin
 * @since 2021-03-31
 */
@Configuration
public class ScopeDemoCase1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeDemoCase1.class);
        Student bean1 = context.getBean(Student.class);
        Student bean2 = context.getBean(Student.class);
        System.out.println(bean1);
    }


    @Component
    public class Teacher {

        @Autowired
        private Student student;

        public void hello() {
            System.out.println(student);
        }
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class Student {
    }
}
