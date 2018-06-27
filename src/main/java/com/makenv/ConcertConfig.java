package com.makenv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// 启用AspectJ自动代理，不然即便使用了AspectJ注解，但它并不会被视为切面
@EnableAspectJAutoProxy
// 如果不配置扫描的路径，默认扫描配置类所在的包及其子包下面的所有类
@ComponentScan
public class ConcertConfig {

}