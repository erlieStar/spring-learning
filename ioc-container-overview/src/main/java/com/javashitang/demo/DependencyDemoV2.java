package com.javashitang.demo;


import com.javashitang.dependency.A;
import com.javashitang.dependency.B;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilimin
 * @since 2022-01-07
 */
public class DependencyDemoV2 {

    private static final Map<String, Object> singletonObjects =
            new HashMap<>(256);

    private static final Map<String, Object> earlySingletonObjects =
            new HashMap<>(256);

    @SneakyThrows
    public static <T> T getBean(Class<T> beanClass) {
        String beanName = beanClass.getSimpleName();
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }
        if (earlySingletonObjects.containsKey(beanName)) {
            return (T) earlySingletonObjects.get(beanName);
        }
        // 实例化bean
        Object object = beanClass.getDeclaredConstructor().newInstance();
        earlySingletonObjects.put(beanName, object);
        // 开始初始化bean，即填充属性
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取需要注入字段的class
            Class<?> fieldClass = field.getType();
            field.set(object, getBean(fieldClass));
        }
        singletonObjects.put(beanName, object);
        earlySingletonObjects.remove(beanName);
        return (T) object;
    }

    public static void main(String[] args) {
        // 假装扫描出来的类
        Class[] classes = {A.class, B.class};
        for (Class aClass : classes) {
            getBean(aClass);
        }
        System.out.println(getBean(A.class).getB() == getBean(B.class));
        System.out.println(getBean(B.class).getA() == getBean(A.class));
    }

}
