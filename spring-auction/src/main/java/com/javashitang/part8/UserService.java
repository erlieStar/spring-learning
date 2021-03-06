package com.javashitang.part8;


import java.util.List;

/**
 * @author lilimin
 * @since 2020-05-28
 */
public interface UserService {

    String getUsername();

    String getLocation(String location);

    boolean saveUserInfo(UserInfo userInfo);

    List<String> getUsernameList(String index);
}
