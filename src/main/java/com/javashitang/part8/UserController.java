package com.javashitang.part8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilimin
 * @since 2020-05-28
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public String getUsername() {
        return userService.getUsername();
    }
}
