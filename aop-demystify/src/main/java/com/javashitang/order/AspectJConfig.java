package com.javashitang.order;

import com.javashitang.transactional.IndexService;
import com.javashitang.transactional.IndexServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public IndexService userService() {
        return new IndexServiceImpl();
    }
}
