package com.streamproject.demo.testpk;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {
    private Long id;
    private Date date;
    private Member member;
}
