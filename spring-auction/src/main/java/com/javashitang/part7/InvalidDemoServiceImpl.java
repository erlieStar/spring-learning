package com.javashitang.part7;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lilimin
 * @since 2020-06-30
 */
@Component
public class InvalidDemoServiceImpl implements InvalidDemoService {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void addUserAndLocation(String username, String location) {
        addUser(username);
        addLocation(location);
    }

    @Override
    public void addUserAndLocationNoT(String username, String location) {
        addAll(username, location);
    }

    @Override
    public void addUserAndLocationNoTV2(String username, String location) {
        InvalidDemoService invalidDemoService = SpringBeanUtil.getBean(InvalidDemoService.class);
        invalidDemoService.addAll(username, location);
    }

    @Transactional
    @Override
    public void addAll(String username, String location) {
        String sql = "insert into user (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{username});
        sql = "insert into location (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{location});
        throw new RuntimeException("保存地址异常");
    }

    public void addUser(String username) {
        String sql = "insert into user (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{username});
    }

    public void addLocation(String location) {
        String sql = "insert into location (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{location});
        throw new RuntimeException("保存地址异常");
    }
}
