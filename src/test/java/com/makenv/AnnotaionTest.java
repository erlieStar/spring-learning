package com.makenv;

import com.st.part2.BraveKnight;
import com.st.part2.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class AnnotaionTest {

    @Autowired
    BraveKnight braveKnight;

    @Test
    public void test() {
        // knife
        System.out.println(braveKnight.getWeapon().getType());
    }
}
