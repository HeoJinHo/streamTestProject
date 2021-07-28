package com.streamproject.demo.testpk;

import java.util.Scanner;

public class KhTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String unit;
        double value;

        System.out.print("단위 변환 입력 : ");
        unit = sc.nextLine();
        sc.nextLine();
        if(unit.equals("cm")){
            System.out.println("cm 값을 입력하면 m 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value / 100.0 + "m 입니다.");
        }else if(unit.equals("m")){
            System.out.println("m 값을 입력하면 cm 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value * 100.0 + "cm 입니다.");
        }else if(unit.equals("g")){
            System.out.println("g 값을 입력하면 kg 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value / 1000.0 + "kg 입니다.");
        }else if(unit.equals("kg")){
            System.out.println("kg 값을 입력하면 g 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value * 1000.0 + "g 입니다.");
        }else if(unit.equals("Byte")){
            System.out.println("Byte 값을 입력하면 KByte 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value / 1024.0 + "KByte 입니다.");
        }else if(unit.equals("KByte")){
            System.out.println("KByte 값을 입력하면 Byte 값으로 변환 합니다.");
            System.out.print(unit + "입력 : ");
            value = sc.nextDouble();
            sc.nextLine();
            System.out.println("결과 : " + value * 1024.0 + "Byte 입니다.");
        }else{
            System.out.println("단위를 잘못 입력하였습니다.");
        }




    }
}