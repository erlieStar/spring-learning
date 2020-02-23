package com.javashitang.part2;

import org.springframework.beans.factory.annotation.Autowired;

public class Weapon {

    @Autowired
    ClassC classC;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClassC getClassC() {
        return classC;
    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }
}
