package com.streamproject.demo.testpk;

import java.util.Scanner;

public class KhTest4 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*
         * 정수값을 입력받을 때 지정된 범위의 입력값이 아닌 경우 최대 3번 다시
         * 입력 받을 수 있도록 하는 코드를 작성한다.(for(if))
         * (지정된 범위는 1 ~ 100사이의 값이다.)
         */
        int ip;
        System.out.print("정수 입력 : ");
        ip = sc.nextInt();


        for(int i=0; i<3; i++){
            if(ip > 0 && ip <= 100){
                System.out.println("입력하신 정수는 : " + ip + "입니다. " + (i+1) + "번째만에 성공한 정수입니다.");
                break;
            }else{
                System.out.print("정수 다시 입력 : ");
                ip = sc.nextInt();
            }
        }



//        if(ip > 0 && ip <= 31){
//            System.out.println("입력하신 정수는 : " + ip);
//        }else{
//            for (int i=0; i<3; i++){
//                System.out.print("정수 다시 입력 : ");
//                ip = sc.nextInt();
//                if(ip > 0 && ip <= 31){
//                    System.out.println("입력하신 정수는 : " + ip);
//                    break;
//                }
//            }
//        }


    }


}
