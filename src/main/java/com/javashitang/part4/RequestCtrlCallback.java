package com.javashitang.part4;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalTime;

public class RequestCtrlCallback implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("request")) {
            LocalTime startTime = LocalTime.of(0, 0, 0);
            LocalTime endTime = LocalTime.of(5, 59, 59);
            LocalTime currentTime = LocalTime.now();
            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                return null;
            }
            return methodProxy.invokeSuper(o, objects);
        }
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new RequestCtrlCallback());

        UserService proxy = (UserService)enhancer.create();
        proxy.request();
    }
}
