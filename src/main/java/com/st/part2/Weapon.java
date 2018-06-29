package com.st.part2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Weapon {

    @Value("knife")
    // 这个值可以从外部配置文件中通过@Value注解读取到
    private String type;

    public String getType() {
        return type;
    }
}
