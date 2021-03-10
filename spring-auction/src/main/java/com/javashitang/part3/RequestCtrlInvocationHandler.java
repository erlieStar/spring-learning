package com.javashitang.part3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class RequestCtrlInvocationHandler implements InvocationHandler {

    private Object target;

    public RequestCtrlInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("request")) {
            LocalTime startTime = LocalTime.of(0, 0, 0);
            LocalTime endTime = LocalTime.of(5, 59, 59);
            LocalTime currentTime = LocalTime.now();
            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                return null;
            }
            return method.invoke(target, args);
        }
        return null;
    }
}
