package com.javashitang.oneOrder;

import com.javashitang.transactional.IndexService;
import com.javashitang.transactional.IndexServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lilimin
 * @since 2021-09-25
 */
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public IndexService userService() {
        return new IndexServiceImpl();
    }
}
