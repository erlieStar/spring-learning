package com.javashitang.aspect;

import com.javashitang.proxy.EchoService;
import com.javashitang.proxy.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectJConfig {

    @Bean
    public EchoService echoService() {
        return (EchoService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{EchoService.class}, new EchoProxy());
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    public class EchoProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return "aaa";
        }
    }
}
