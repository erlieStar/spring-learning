package com.javashitang.aspectjPointcut.annotationDemo;

import com.javashitang.aspectjPointcut.targetDemo.Target;
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
public class AnnotationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationDemo.class, AspectDefine.class);
        Student student = context.getBean(Student.class);
        student.test();
        System.out.println("---");
        student.getName();
    }


    @Aspect
    public class AspectDefine {
        @Before("@annotation(com.javashitang.aspectjPointcut.annotationDemo.Log)")
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

        @Log
        public void test() {

        }
    }

    public interface Name {
        String getName();
    }
}
