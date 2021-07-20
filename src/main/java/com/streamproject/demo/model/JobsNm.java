package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobsNm extends Member
{

    private String jobName;


    public void  info()
    {
        super.info();
        System.out.println("직업 : " + jobName);
    }

}
