package com.javashitang.part8;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2020-05-28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ManageServiceTest {

    @Autowired
    private ManageService manageService;

    private UserService userService;

    @Test
    public void getUsername() throws Exception {

        // userService mock
        userService = EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.getUsername()).andReturn("test");
        Field userServiceField = manageService.getClass().getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(manageService, userService);
        EasyMock.replay(userService);

        String username = manageService.getUsername();
        System.out.println(username);
        assertEquals(username, "test");
    }

    @Test
    public void getLocation1() throws Exception {

        // userService mock
        userService = EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.getUsername()).andReturn("test");
        Field userServiceField = manageService.getClass().getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(manageService, userService);
        EasyMock.replay(userService);

        String username = manageService.getUsername();
        System.out.println(username);
    }

    @Test
    public void saveUserInfo() throws Exception {

        userService = EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.saveUserInfo(EasyMock.anyObject())).andReturn(true);
        Field userServiceField = manageService.getClass().getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(manageService, userService);
        EasyMock.replay(userService);

        boolean flag = manageService.saveUserInfo(EasyMock.anyObject());
        System.out.println(flag);
        assertTrue(flag);
    }

    @Test
    public void getUsernameList() throws Exception {
        List<String> nameList = new ArrayList<>();
        nameList.add("7");
        nameList.add("8");
        userService = EasyMock.createMock(UserService.class);
        EasyMock.expect(userService.getUsernameList("1")).andReturn(nameList);
        Field userServiceField = manageService.getClass().getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(manageService, userService);
        EasyMock.replay(userService);

        List<String> usernameList = manageService.getUsernameList("1");
        System.out.println(usernameList);
    }
}