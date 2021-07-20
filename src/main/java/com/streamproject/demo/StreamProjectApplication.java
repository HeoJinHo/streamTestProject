package com.streamproject.demo;

import com.streamproject.demo.model.JobsNm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class StreamProjectApplication {

    public static void main(String[] args) {

        long count = 0;
        String str = "";

        List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");

        System.out.println("-----------------for 문 대체 lamda식 start ------------------");
        names.stream()
                .forEach(y -> System.out.println(y));

        System.out.println("-----------------for 문 대체 lamda식 end ------------------");


        List<String> strs = Arrays.asList("1", "2", "3", "4", "5", "1", "2", "3", "4", "5");

        System.out.println("-----------------contains(\"pro\") : 객수 구하기 start ------------------");

        count = 0;
        count = names.stream().filter(x -> x.contains("pro")).count();
        System.out.println("Count : " + count);

        System.out.println("-----------------contains(\"pro\") : 객수 구하기 end ------------------");


        System.out.println("----------- contains(\"j\") : 포함한 것만 가져오기 start -----------------------");
        names.stream().filter(y -> y.contains("j"))
                .forEach(y -> System.out.println(y));

        System.out.println("----------- contains(\"j\") : 포함한 것만 가져오기 end -----------------------");


        System.out.println("---------------- concat(\"!\"): 끝에다가 문자 추가하기 start -------------------");

        names.parallelStream()
                .map(t -> t.concat("!"))
                .forEach(t -> System.out.println(t));

        System.out.println("---------------- concat(\"!\"): 끝에다가 문자 추가하기 end -------------------");


        System.out.println("--------------------limit or skip and filter-------------------");
        List<Integer> moneys = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3);
        moneys.stream()
                .filter(m -> m >= 4)
                .limit(3)
                .skip(1)
                .forEach(m -> System.out.println(m));

        System.out.println("--------------------limit or skip and filter-------------------");


        System.out.println("----------------distinct----------------------");

        moneys.stream()
                .distinct()
                .forEach(k -> System.out.println(k));

        System.out.println("----------------distinct--------------------");




        System.out.println("--------------------limit or skip-------------------");
        IntStream.range(0, 10).forEach(i -> {
            if (i >= 5) {
                return;
            }
            System.out.println(i);
        });
        System.out.println("========================111111============================");
        for (int i=0; i<10; i++){
            if (i == 5){
                break;
            }
            System.out.println(i);

        }
        System.out.println("=========================222222===========================");

        try {
            IntStream.range(0, 10).forEach(i -> {
                    if (i == 5) {
                        throw new RuntimeException("stop");
                    }
                    System.out.println(i);
            });
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("--------------------limit or skip-------------------");


        JobsNm jobsNm = new JobsNm();

        jobsNm.setMemberID("test");
        jobsNm.setJobName("DEV");

        jobsNm.info();


        System.out.println("--------------------Test-------------------");


        List<Integer> nums = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        nums.forEach((i)-> System.out.println(i+1));

        System.out.println("--------------------Test-------------------");



        SpringApplication.run(StreamProjectApplication.class, args);
    }

}
