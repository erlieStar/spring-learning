package com.javashitang;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author lilimin
 * @since 2021-03-11
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        for (String beanDefinitionName : factory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            beanDefinition.setScope("prototype");
        }
    }
}
