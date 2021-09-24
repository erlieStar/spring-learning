package com.javashitang.pointcut;

import lombok.Data;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author lilimin
 * @since 2021-09-24
 */
@Data
public class EchoStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {

    private String methodName;

    private Class targetClass;

    public EchoStaticMethodMatcherPointcut(String methodName, Class targetClass) {
        this.methodName = methodName;
        this.targetClass = targetClass;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return Objects.equals(methodName, method.getName())
                && this.targetClass.isAssignableFrom(targetClass);
    }
}
