package com.javashitang.transactional;

import org.springframework.transaction.annotation.Transactional;

public class DemoService {

    @Transactional(rollbackFor = Exception.class)
    protected String index() {
        System.out.println("index");
        return "index";
    }
}
