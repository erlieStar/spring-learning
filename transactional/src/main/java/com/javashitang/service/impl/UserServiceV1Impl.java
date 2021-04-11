package com.javashitang.service.impl;

import com.javashitang.service.inf.LocationService;
import com.javashitang.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author lilimin
 * @since 2021-04-11
 */
//@Service
public class UserServiceV1Impl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void addUser(String name, String location) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    String sql = "insert into user (`name`) values (?)";
                    jdbcTemplate.update(sql, new Object[]{name});
                    throw new RuntimeException("保存用户信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                    status.setRollbackOnly();
                }
            }
        });
    }
}
