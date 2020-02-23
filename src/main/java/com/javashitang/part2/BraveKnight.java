package com.javashitang.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight {

    @Autowired
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }
}
