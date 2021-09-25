package com.javashitang.aspect;

import com.javashitang.proxy.DefaultEchoService;
import com.javashitang.proxy.EchoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }
}
