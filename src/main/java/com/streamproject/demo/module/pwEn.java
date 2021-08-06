package com.streamproject.demo.module;

import org.mindrot.jbcrypt.BCrypt;

public class pwEn
{

    public static void main(String[] args) {
        String hashpw = BCrypt.hashpw("a0000000!", BCrypt.gensalt());


        System.out.println(hashpw);


        boolean a001212 = BCrypt.checkpw("a0000000!", hashpw);

        System.out.println(a001212);



    }


}
