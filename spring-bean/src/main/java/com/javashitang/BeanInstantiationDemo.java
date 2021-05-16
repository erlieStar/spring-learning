package com.javashitang;

import com.javashitang.domain.User;
import com.javashitang.factory.UserFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/bean-instantiation-context.xml");
		User user1 = beanFactory.getBean("user-by-constructor", User.class);
		User user2 = beanFactory.getBean("user-by-static-method", User.class);
		User user3 = beanFactory.getBean("user-by-factory", User.class);
		User user4 = beanFactory.getBean("user-by-factory-bean", User.class);
        UserFactoryBean userFactoryBean = beanFactory.getBean("&" + "user-by-factory-bean", UserFactoryBean.class);

		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);
        System.out.println(userFactoryBean);

	}
}