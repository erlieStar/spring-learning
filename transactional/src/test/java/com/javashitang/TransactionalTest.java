package com.javashitang;

import com.javashitang.config.AppConfig;
import com.javashitang.service.inf.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-04-11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TransactionalTest {

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        userService.addUser("test", "test");
        System.out.println("finish");
    }


    @Test
    @Transactional
    @Rollback(false)
    public void test2() {
        String sql = "insert into location (`id`, `name`) values (5, 'test')";
        int num = jdbcTemplate.update(sql);
        System.out.println("update num " + num);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        System.out.println("start");
        String sql = "select count(*) from location where id = 5";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        if (count == 0) {
            String updateSql = "insert into location (`id`, `name`) values (5, 'test')";
            int num = jdbcTemplate.update(updateSql);
            System.out.println("update num " + num);
        } else {
            System.out.println("count is not 0");
        }
    }

    @Test
    public void v1() {
        userService.addUser("test", "test");
    }
}
