package com.javashitang.transactional;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://myhost:3306/test?characterEncoding=utf8&useSSL=true");
        ds.setUsername("test");
        ds.setPassword("test");
        ds.setInitialSize(5);
        return ds;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate(dataSourceTransactionManager());
    }

    @Bean
    public IndexService userService() {
        return new IndexServiceImpl();
    }
}
