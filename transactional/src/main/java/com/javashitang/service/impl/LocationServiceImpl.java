package com.javashitang.service.impl;

import com.javashitang.service.inf.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lilimin
 * @since 2021-04-11
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLocation(String location) {
        String sql = "insert into location (`name`) values (?)";
        jdbcTemplate.update(sql, new Object[]{location});
        throw new RuntimeException("保存地址异常");
    }
}

