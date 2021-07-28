package com.streamproject.demo.testpk;

import com.streamproject.demo.model.Apple;
import com.streamproject.demo.model.Builder;
import org.junit.Test;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest
{

    public static void main(String[] args) {


        ArrayList<Builder> setBuilders = new ArrayList<>();
        setBuilders.add(new Builder("허진호1", "공항동", 500));
        setBuilders.add(new Builder("허진호2", "마곡동", 250));
        setBuilders.add(new Builder("허진호3", "등촌동", 100));


        String likeStr = "동";
//
//        List<Builder> newList = setBuilders.stream()
//                .anyMatch(w -> w.equals(likeStr));

        List<Builder> newList = setBuilders.stream().filter(x -> x.getAddr().contains(likeStr)).collect(Collectors.toList());

        newList.forEach(o -> System.out.println(o.getName()));

        String collJoing = newList.stream().map(Builder::getName).collect(Collectors.joining(", "));

        List<String> newNameList = newList.stream().map(Builder::getName).collect(Collectors.toList());

        int maxValue = 0;
        Optional<Builder> max = setBuilders.stream().max(Comparator.comparing(Builder::getTotal));

        if(max.isPresent()){
            maxValue = max.get().getTotal();
        }

        System.out.println("최대값1 : " + maxValue);


        int totalValue = setBuilders.stream().mapToInt(Builder::getTotal).sum();

        OptionalInt maxValue2 = setBuilders.stream().mapToInt(Builder::getTotal).max();
        System.out.println("합계값 : " + totalValue);
        System.out.println("최대값2 : " + maxValue2.orElse(1));


        // IntStream.range => 시작값과 마지막값이 미포함되어 loop
        // IntStream.rangeClosed => 시작값과 마지막 값이 포함되어 loop
        IntStream intStream = IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0);
        System.out.println("1~10까지의 짝수 : " + intStream.count());


//        Stream.iterate(0, n -> n + 2).limit(50).forEach(System.out::println);


        // 피보나치 출력
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], (t[0] + t[1])})
                .limit(20).forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ") = " + (t[0]+t[1])));

        Stream.generate(Math::random).limit(10).forEach(System.out::println);


        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });


        System.out.println(twos.max());




        ArrayList<Builder> setBuilders2 = new ArrayList<>();
        setBuilders2.add(new Builder("허진호1", "공항동", 500));
        setBuilders2.add(new Builder("허진호1", "마곡동", 250));
        setBuilders2.add(new Builder("허진호1", "등촌동", 100));

        String testStr = "허진호1";
        boolean b = setBuilders2.stream().allMatch(x -> x.getName().equals(testStr));

        System.out.println(b);



    }



}
