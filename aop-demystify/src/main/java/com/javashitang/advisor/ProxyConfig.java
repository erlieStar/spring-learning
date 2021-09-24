package com.javashitang.advisor;

import com.javashitang.proxy.DefaultEchoService;
import com.javashitang.proxy.EchoService;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;

import java.beans.EventHandler;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class ProxyConfig {

    @Bean
    public EchoService echoService() {
        return new DefaultEchoService();
    }

    @Bean
    public Pointcut pointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("echo");
        return pointcut;
    }

    @Bean
    public CostMethodInterceptor costInterceptor() {
        return new CostMethodInterceptor();
    }

    @Bean
    public Advisor advisor(Pointcut pointcut, Advice advice) {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);
        return advisor;
    }

    @Bean("echoProxy")
    public ProxyFactoryBean proxyFactoryBean(EchoService echoService) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(echoService);
        proxyFactoryBean.setInterceptorNames("advisor");
        return proxyFactoryBean;
    }
}
