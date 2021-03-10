package com.javashitang;

import com.javashitang.domain.BeanMethod;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanInitializationDemo {

	public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(BeanInitializationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("Spring 应用上下文已启动...");
        // 依赖查找 UserFactory
        BeanMethod beanMethod = applicationContext.getBean(BeanMethod.class);
        System.out.println(beanMethod);
        System.out.println("Spring 应用上下文准备关闭...");
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");

	}

    @Bean(initMethod = "customerInit", destroyMethod = "customerDestroy")
    public BeanMethod userFactory() {
        return new BeanMethod();
    }
}