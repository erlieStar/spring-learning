package com.javashitang.aspectjPointcut.thisDemo;

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
public class ThisDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ThisDemo.class, AspectDefine.class);
        Name name = context.getBean(Name.class);
        name.getName();
        System.out.println(name instanceof Student);
    }


    @Aspect
    public class AspectDefine {
        @Before("this(com.javashitang.aspectjPointcut.thisDemo.ThisDemo.Student)")
        public void before() {
            System.out.println("before");
        }
    }

    @Bean
    public Student student() {
        return new Student();
    }

    public class Student implements Name {

        @Override
        public String getName() {
            return null;
        }
    }

    public interface Name {
        String getName();
    }
}
