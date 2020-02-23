package com.javashitang.part2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 如果不配置扫描的路径，默认扫描配置类所在的包及其子包下面的所有类
// 可以通过属性basePackages = {""}指定扫描的包
@ComponentScan()
public class MyConfig {

    // name属性默认是方法名，自己可以指定
    @Bean(name = "weapon")
    public Weapon weapon() {
        Weapon weapon = new Weapon();
        weapon.setType("knife");
        return weapon;
    }
}
