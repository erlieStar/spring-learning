package com.javashitang;

import com.javashitang.config.AppConfig;
import com.javashitang.service.inf.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lilimin
 * @since 2021-04-11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TransactionalTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.addUser("test", "test");
        System.out.println("finish");
    }
}
