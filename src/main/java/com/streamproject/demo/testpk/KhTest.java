package com.streamproject.demo.testpk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class KhTest
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String inPut = "";
//        String outPut = "";
//
//        System.out.print("단위를 입력해주세요 : ");
//        inPut = sc.nextLine();
//        System.out.print("변환할 숫자입력 : " );
//        double inInt = sc.nextInt();
//
//        DecimalFormat dcf = new DecimalFormat();
//
//        switch (inPut){
//            case "cm":
//                outPut = dcf.format((inInt / 100)) + "m";
//                break;
//            case "m":
//                outPut = dcf.format((inInt * 100)) + "cm";
//                break;
//            case "g":
//                outPut = dcf.format((inInt / 100)) + "kg";
//                break;
//            case "kg":
//                outPut = dcf.format((inInt * 100)) + "g";
//                break;
//            case "Byte":
//                outPut = dcf.format(((inInt / 1000)+(24*inInt))) + "MByte";
//                break;
//            case "MByte":
//                outPut = dcf.format(((inInt * 1000)+(24*inInt))) + "Byte";
//                break;
//        }
//
//        System.out.printf("%s%s 값을 입력하면 %s값으로 변환합니다.\n", dcf.format(inInt), inPut, outPut);

        String unit;
        double value;

        System.out.print("단위 변환 입력 : ");
        unit = sc.nextLine();
        sc.nextLine();



        switch(unit) {
            case "cm":
                System.out.println("cm 값을 입력하면 m 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value / 100.0 + "m 입니다.");
                break;
            case "m" :
                System.out.println("m 값을 입력하면 cm 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value * 100.0 + "cm 입니다.");
                break;
            case "g":
                System.out.println("g 값을 입력하면 kg 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value / 1000.0 + "kg 입니다.");
                break;
            case "kg":
                System.out.println("kg 값을 입력하면 g 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value * 1000.0 + "g 입니다.");
                break;
            case "Byte":
                System.out.println("Byte 값을 입력하면 KByte 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value / 1024.0 + "KByte 입니다.");
                break;
            case "KByte":
                System.out.println("KByte 값을 입력하면 Byte 값으로 변환 합니다.");
                System.out.print(unit + "입력 : ");
                value = sc.nextDouble();
                sc.nextLine();
                System.out.println("결과 : " + value * 1024.0 + "Byte 입니다.");
                break;
            default :
                System.out.println("단위를 잘못 입력하였습니다.");

        }
    }


    /*
     * 단위 변환 프로그램 만들기
     *
     * 1. cm -> m로 변환 또는 m -> cm 로 변환 하는 기능을 만든다.
     * 2. g - > kg 으로 kg -> g 으로 변환하는 기능을 만든다.
     * 3.Byte -> MByte로 MByte를 Byte로 변환하는 기능을 만든다.
     *
     * 각각의 기능은 처음 입력하는 단위가 무엇인가에 따라 바뀌게 된다.
     * 예 1.)
     *       단위변환 입력 : cm
     *       cm값을 입력하면 m값으로 변환합니다.
     *       cm 입력 : 100
     *       결과 : 1m 입니다.
     *
     * 예 2.)
     *       단위변환 입력 : MByte
     *       MByte 값을 입력하면 Byte 값으로 변환 합니다.
     *       MByte 입력 : 1
     *       결과 : 1024Byte 입니다.
     */


}


/**
 *       String unit;
 *       double value;
 *
 *       System.out.print("단위 변환 입력 : ");
 *       unit = sc.nextLine();      sc.nextLine();
 *
 *       switch(unit) {
 *             case"cm":
 *                System.out.println("cm 값을 입력하면 m 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value / 100.0 + "m 입니다.");
 *                break;
 *             case"m" :
 *                System.out.println("m 값을 입력하면 cm 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value * 100.0 + "cm 입니다.");
 *                break;
 *             case"g":
 *                System.out.println("g 값을 입력하면 kg 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value / 1000.0 + "kg 입니다.");
 *                break;
 *             case"kg":
 *                System.out.println("kg 값을 입력하면 g 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value * 1000.0 + "g 입니다.");
 *                break;
 *             case"Byte":
 *                System.out.println("Byte 값을 입력하면 KByte 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value / 1024.0 + "KByte 입니다.");
 *                break;
 *             case"KByte":
 *                System.out.println("KByte 값을 입력하면 Byte 값으로 변환 합니다.");
 *                System.out.print(unit + "입력 : ");
 *                value = sc.nextDouble();      sc.nextLine();
 *                System.out.println("결과 : " + value * 1024.0 + "Byte 입니다.");
 *                break;
 *             default :
 *                System.out.println("단위를 잘못 입력하였습니다.");
 *
 *       }
 */
