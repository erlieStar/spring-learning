package com.javashitang;

import com.javashitang.domain.Animal;
import com.javashitang.domain.Student;
import com.javashitang.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.beans.PropertyDescriptor;

/**
 * @author lilimin
 * @since 2021-03-11
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化前阶段
     * 返回为null，说明继续让spring创建bean
     * 返回不为null，bean已经在这个方法中创建好了，不需要再进行后续的处理了
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("animal", beanName) && Animal.class.equals(beanClass)) {
            Animal animal = new Animal();
            animal.setName("老虎");
            animal.setSpeed(100L);
            return animal;
        }
        return null;
    }

    /**
     * 属性赋值前阶段
     * bean已经被实例化，bean的属性还没有被设置，都是null
     * 返回false，忽略属性值的设置
     * 返回true，按照正常流程设置属性值
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
            User user = (User) bean;
            user.setId(10L);
            user.setName("li");
            return false;
        }
        return true;
    }


    /**
     * 属性赋值阶段
     * 对属性值进行修改
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("student", beanName) && Student.class.equals(bean.getClass())) {
            MutablePropertyValues propertyValues;
            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }

            propertyValues.addPropertyValue("age", 20);
            if (propertyValues.contains("description")) {
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description", "v2");
                System.out.println("v2");
            }
        }
        return null;
    }

    /**
     * 初始化前阶段
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("student", beanName) && Student.class.equals(bean.getClass())) {
            Student student = (Student) bean;
            student.setDescription("v3");
            System.out.println("v3");
        }
        return bean;
    }

    /**
     * 初始化后阶段
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("student", beanName) && Student.class.equals(bean.getClass())) {
            Student student = (Student) bean;
            student.setDescription("v7");
            System.out.println("v7");
        }
        return bean;
    }
}
