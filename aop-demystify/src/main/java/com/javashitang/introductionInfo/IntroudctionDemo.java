package com.javashitang.introductionInfo;

import com.javashitang.proxy.DefaultEchoService;
import com.javashitang.proxy.EchoService;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author lilimin
 * @since 2021-09-25
 */
public class IntroudctionDemo {

    public static void main(String[] args) {
        SayName sayName = new DefaultSayName();
        EchoService echoService = new DefaultEchoService();
        DelegatingIntroductionInterceptor interceptor =
                new DelegatingIntroductionInterceptor(sayName);
        Advisor advisor = new DefaultIntroductionAdvisor(interceptor, SayName.class);
        ProxyFactory proxyFactory = new ProxyFactory(echoService);
        proxyFactory.addAdvisor(advisor);
        // hello world
        EchoService proxyService = (EchoService) proxyFactory.getProxy();
        System.out.println(proxyService.echo("hello world"));
        // I am service
        SayName proxySayName = (SayName) proxyFactory.getProxy();
        System.out.println(proxySayName.getName());
    }
}
