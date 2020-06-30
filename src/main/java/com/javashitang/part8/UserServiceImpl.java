package com.javashitang.part8;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean saveUserInfo(UserInfo userInfo) {
        return false;
    }

    @Override
    public List<String> getUsernameList(String index) {
        List<String> nameList = new ArrayList<>();
        nameList.add("1");
        nameList.add("2");
        return nameList;
    }
}
