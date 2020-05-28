package com.javashitang.part8;

import org.springframework.stereotype.Service;

/**
 * @author lilimin
 * @since 2020-05-28
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUsername() {
        return "username";
    }

    @Override
    public String getLocation(String location) {
        return "location";
    }
}
