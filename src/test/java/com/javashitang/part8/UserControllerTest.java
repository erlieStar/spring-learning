package com.javashitang.part8;

import com.javashitang.part8.AppConfig;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2020-05-28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    private UserService userService;

    @Test
    public void getUsername() throws Exception {

        userService = EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.getUsername()).andReturn("test");
        Field userServiceField = userController.getClass().getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(userController, userService);
        EasyMock.replay(userService);
        String username = userController.getUsername();
        System.out.println(username);
    }
}