package com.javashitang.part6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.publishEvent(new NewArticleEvent(context, "Jva识堂", "《五分钟学会观察者模式》"));
		context.close();
	}
}
