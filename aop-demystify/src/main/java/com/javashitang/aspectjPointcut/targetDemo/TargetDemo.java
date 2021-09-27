package com.javashitang.aspectjPointcut.targetDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-27
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TargetDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TargetDemo.class, AspectDefine.class);
        Student student = context.getBean(Student.class);
        student.getName();
        student.test();
        student.getName();
    }


    @Aspect
    public class AspectDefine {
        @Before("@target(com.javashitang.aspectjPointcut.targetDemo.Target)")
        public void before() {
            System.out.println("before");
        }
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Target
    public class Student implements Name {

        @Override
        public String getName() {
            return null;
        }

        public void test() {

        }
    }

    public interface Name {
        String getName();
    }
}
