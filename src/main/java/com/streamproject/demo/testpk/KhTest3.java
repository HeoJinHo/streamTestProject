package com.streamproject.demo.testpk;

import java.util.Scanner;

public class KhTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String unit;
        double value;

        String[] dan1 = {"cm", "g", "Byte"};
        String[] dan2 = {"m", "kg", "KByte"};
        System.out.print("단위 변환 입력 : ");
        unit = sc.nextLine();
        String val = "";
        boolean van = false;
        for (int i=0; i<dan1.length; i++){
            if(unit.equals(dan1[i])){
                val = dan2[i];
                van = true;
            }
        }

        for (int k=0; k<dan2.length; k++){
            if(unit.equals(dan2[k])){
                val = dan1[k];
                van = false;
            }
        }

        System.out.println(unit + "값을 입력하면 " + val + "값으로 변환 합니다.");
        System.out.print(unit + "입력 : ");
        value = sc.nextDouble();
        sc.nextLine();

        if (van){
            System.out.println("결과 : " + value / 100.0 +  (val)+ "입니다.");
        }else{
            System.out.println("결과 : " + value * 100.0 + (val)+" 입니다.");
        }


    }
}