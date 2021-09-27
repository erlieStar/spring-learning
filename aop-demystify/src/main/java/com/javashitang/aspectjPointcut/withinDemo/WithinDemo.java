package com.javashitang.aspectjPointcut.withinDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-27
 */
@WithIn
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WithinDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(WithinDemo.class, AspectDefine.class);
        WithinDemo bean = context.getBean(WithinDemo.class);
        bean.test1();
        bean.test2();
    }

    public void test1() {

    }

    public void test2() {

    }


    @Aspect
    public class AspectDefine {
        @Before("@within(com.javashitang.aspectjPointcut.withinDemo.WithIn)")
        public void before() {
            System.out.println("before");
        }
    }
}
