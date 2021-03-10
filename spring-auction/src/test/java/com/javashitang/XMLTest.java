package com.javashitang;


import com.javashitang.part1.BraveKnight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
// 多个文件时可用locations = {"", ""}
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class XMLTest {

    @Autowired
    BraveKnight braveKnight;

    @Test
    public void test() {
        // knife
        System.out.println(braveKnight.getWeapon().getType());
    }
}
