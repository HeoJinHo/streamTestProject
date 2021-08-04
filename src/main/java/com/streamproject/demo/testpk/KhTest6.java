package com.streamproject.demo.testpk;

import java.util.Scanner;

public class KhTest6 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        for(int i=1; i<8; i++){
            System.out.print(i);
            if(i == 7){
                System.out.println();
                for(int k=8; k<15; k++){
                    System.out.print(k);

                    if(k == 14){
                        System.out.println();
                        for(int l=15; l<22; l++){
                            System.out.print(l);
                        }
                    }

                }
            }
        }

    }


}
