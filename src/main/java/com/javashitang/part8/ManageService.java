package com.javashitang.part8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lilimin
 * @since 2020-05-28
 */
@Service
public class ManageService {

    @Autowired
    private UserService userService;

    public String getUsername() {
        return userService.getUsername();
    }

    public String getLocation(String name) {
        return userService.getLocation(name);
    }

    public boolean saveUserInfo(UserInfo userInfo) {
        return userService.saveUserInfo(userInfo);
    }
}
