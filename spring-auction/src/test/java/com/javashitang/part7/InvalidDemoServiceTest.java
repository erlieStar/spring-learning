package com.javashitang.part7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2020-06-30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class InvalidDemoServiceTest {

    @Resource
    private InvalidDemoService invalidDemoService;

    @Test
    public void addUserAndLocation() {
        invalidDemoService.addUserAndLocation("用户名", "地址");
    }


    @Test
    public void addUserAndLocationNoT() {
        invalidDemoService.addUserAndLocationNoT("用户名", "地址");
    }

    @Test
    public void addUserAndLocationNoTV2() {
        invalidDemoService.addUserAndLocationNoTV2("用户名", "地址");
    }
}