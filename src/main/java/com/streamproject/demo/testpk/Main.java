package com.streamproject.demo.testpk;



public class Main {
    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();

        if(n >=1 && n<=9){
            java.util.stream.IntStream.rangeClosed(1, 9).forEach((i)->
                {
                    System.out.println(""+n+" * " + ""+i+" = " + n*i);
                }
            );
        }
    }
}
