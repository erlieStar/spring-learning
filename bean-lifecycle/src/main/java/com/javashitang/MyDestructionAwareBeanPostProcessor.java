package com.javashitang;

import com.javashitang.domain.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @author lilimin
 * @since 2021-03-11
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("student", beanName) && Student.class.equals(bean.getClass())) {
            Student student = (Student) bean;
            student.setDescription("v9");
            System.out.println("v9");
        }
    }
}
