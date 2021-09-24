package com.javashitang.advisor;

import com.javashitang.proxy.DefaultEchoService;
import com.javashitang.proxy.EchoService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class AutoProxyConfig {

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

    @Bean
    public DefaultAdvisorAutoProxyCreator autoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
