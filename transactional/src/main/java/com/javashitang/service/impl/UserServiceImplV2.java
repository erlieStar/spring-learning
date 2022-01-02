package com.javashitang.service.impl;

import com.javashitang.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author lilimin
 * @since 2022-01-02
 */
//@Service
public class UserServiceImplV2 implements UserService {

    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(String name, String location) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                String sql = "insert into user (`name`) values (?)";
                jdbcTemplate.update(sql, new Object[]{name});
            }
        });
    }
}
