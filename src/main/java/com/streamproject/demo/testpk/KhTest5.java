package com.streamproject.demo.testpk;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KhTest5 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*
         * 정수값을 입력받아 1 부터 입력받은 값까지 1씩 증가된 값을 누적하여 합을 구하는 코드를
         * 작성한다.
         *
         * 예 1.)
         *       정수 입력 : 3
         *       누적합 : 6
         *
         * 예 2.)
         *       정수 입력 : 5
         *       누적합 : 15
         *
         * 예 3.)
         *       정수 입력 : 10
         *       누적합 : 55
         */

//        int value;
//        System.out.print("정수를 입력하세요 : " );
//        value = sc.nextInt();
//        int total = 0;
//        for(int i=1; i<value+1; i++){
//            total = total + i;
//        }
//        System.out.println("입력값은 : " + value + "이고, 누적합계는 : " + total + "입니다.");
//
//
//        int test = IntStream.range(1, value+1).sum();
//        System.out.println("입력값은 : " + value + "이고, 누적합계는 : " + test + "입니다.");



        String str;
        int num, total2;
        System.out.print("파일명 입력 : ");
        str = sc.nextLine();
        System.out.print("생성 파일 수 : ");
        num = sc.nextInt();
        System.out.println(str);
        if(num == 1) {
            System.out.println("결과\n" + "   " + str + " 생성 완료!");
        }else {
            System.out.println("결과");
            for (int i = 1; i <= num; i++) {
                total2 = i;
                System.out.printf("    " + str + "[%d] 생성 완료!\n", total2);
            }
        }

    }


}
