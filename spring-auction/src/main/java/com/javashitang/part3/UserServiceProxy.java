package com.javashitang.part3;

import java.time.LocalTime;

public class UserServiceProxy implements UserService {

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void request() {
        LocalTime startTime = LocalTime.of(0, 0, 0);
        LocalTime endTime = LocalTime.of(5, 59, 59);
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return;
        }
        userService.request();
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        // welcome sir
        userServiceProxy.request();
    }
}
