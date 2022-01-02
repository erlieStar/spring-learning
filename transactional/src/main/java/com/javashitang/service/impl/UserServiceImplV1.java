package com.javashitang.service.impl;

import com.javashitang.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author lilimin
 * @since 2022-01-02
 */
//@Service
public class UserServiceImplV1 implements UserService {

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(String name, String location) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setTimeout(200);
        TransactionStatus txStatus = transactionManager.getTransaction(definition);

        try {
            String sql = "insert into user (`name`) values (?)";
            jdbcTemplate.update(sql, new Object[]{name});
            transactionManager.commit(txStatus);
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
        }
    }
}
