package com.javashitang.advisor;

import com.javashitang.proxy.DefaultEchoService;
import com.javashitang.proxy.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author lilimin
 * @since 2021-09-24
 */
public class AdvisorDemo {

    public static void main(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("echo");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(new CostMethodInterceptor());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new DefaultEchoService());
        proxyFactory.addAdvisor(advisor);
        EchoService echoService = (EchoService) proxyFactory.getProxy();
        System.out.println(echoService.echo("hello world"));
    }
}