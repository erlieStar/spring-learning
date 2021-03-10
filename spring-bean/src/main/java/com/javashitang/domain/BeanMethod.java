package com.javashitang.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lilimin
 * @since 2021-03-10
 */
public class BeanMethod implements InitializingBean, DisposableBean {


	public BeanMethod() {
		System.out.println("构造方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean#afterPropertiesSet");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("@PostConstruct");
	}

	public void customerInit() {
		System.out.println("customerInit");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean#destroy");
	}

	public void customerDestroy() {
		System.out.println("customerDestroy");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy");
	}
}
