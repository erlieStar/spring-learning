package com.javashitang.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
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
public class LookupDemoCase3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LookupDemoCase3.class);
        Teacher teacher = context.getBean(Teacher.class);
        for (int i = 0; i < 3; i++) {
            teacher.hello();
        }
    }


    @Component
    public abstract class Teacher {

        @Lookup
        public abstract Student getStudent();

        public void hello() {
            System.out.println(getStudent());
        }
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class Student {
    }
}
