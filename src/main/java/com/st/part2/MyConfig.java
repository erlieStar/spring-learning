package com.st.part2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 如果不配置扫描的路径，默认扫描配置类所在的包及其子包下面的所有类
@ComponentScan
public class MyConfig {
}
