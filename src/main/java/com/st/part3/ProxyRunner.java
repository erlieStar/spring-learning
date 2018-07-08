package com.st.part3;

import java.lang.reflect.Proxy;

public class ProxyRunner {

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(
                ProxyRunner.class.getClassLoader(),
                new Class[] {UserService.class},
                new RequestCtrlInvocationHandler(new UserServiceImpl())
        );
        // welcome sir
        userService.request();
    }
}
