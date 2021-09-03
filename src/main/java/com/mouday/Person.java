package com.mouday;

import java.io.Serializable;

public class Person implements Serializable {
    // 序列化前后的唯一标识符
    private static final long serialVersionUID = 1;

    private String name;
    private int age;
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
