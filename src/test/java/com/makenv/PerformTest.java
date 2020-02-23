package com.makenv;

import com.javashitang.part5.ConcertConfig;
import com.javashitang.part5.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//用来初始化Spring的上下文环境
@ContextConfiguration(classes = ConcertConfig.class)
public class PerformTest {

    @Autowired
    Performance performance;

    @Test
    public void play() {
        //Silencing cell phones
        //表演开始
        //CLAP CALP!!
        performance.perform();
    }
}
