package com.streamproject.demo.testpk;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3
{


    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("홍길동",92),
                new Student("김남준",90)
        );


        Stream<Student> stream = list.stream();
        stream.forEach(s -> {
            String name = s.getName();
            int score = s.score + s.getScore();
            System.out.println(name + "-" + score);
        });

        System.out.println("-------------------------------------------------");
        Stream<Student> stream2 = list.stream();
        stream2.forEach(s -> {
            String name = s.getName();
            int score = s.getScore();
            System.out.println(name + "-" + score);
        });


        System.out.println("-------------------------------------------------");

        int testScore = 0;
        for (Student student : list) {
            testScore = testScore + student.getScore();
            System.out.println(student.getName() + " : " + testScore);
        }

        System.out.println("Hello World!");

    }



}
