package com.streamproject.demo.testpk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {


    String name;
    int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
