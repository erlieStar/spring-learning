package com.javashitang.transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lilimin
 * @since 2022-01-05
 */
public class IndexServiceImpl implements IndexService {

    @Cacheable("test")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String index() {
        System.out.println("index");
        return "index";
    }
}
