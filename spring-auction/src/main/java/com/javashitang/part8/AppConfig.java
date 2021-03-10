package com.javashitang.part8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.javashitang.part8")
@EnableTransactionManagement
public class AppConfig {
}
