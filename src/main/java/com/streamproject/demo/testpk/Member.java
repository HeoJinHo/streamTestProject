package com.streamproject.demo.testpk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member
{
    private Long id;
    private String name;
    private Address address;
}
