package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member
{
    private String memberID;

    public void info()
    {
        System.out.println("사용자 이름 : " + memberID);
    }

}
