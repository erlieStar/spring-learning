package com.javashitang.service.impl;

import com.javashitang.service.inf.LocationService;
import com.javashitang.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lilimin
 * @since 2021-04-11
 */
@Service
public class UserServiceV3Impl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LocationService locationService;

    @Override
    @Transactional
    public void addUser(String name, String location) {
        String sql = "insert into user (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{name});
        try {
            locationService.addLocation(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

