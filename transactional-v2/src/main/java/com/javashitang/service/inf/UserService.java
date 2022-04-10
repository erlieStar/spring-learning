package com.javashitang.service.inf;

/**
 * @author lilimin
 * @since 2021-04-11
 */
public interface UserService {
    void addUser(String name, String location);
    default void doAdd(String name) {};
    default void addThrowIo(String name) {};
}

