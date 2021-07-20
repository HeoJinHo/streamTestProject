package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction2
{
    private String tong;

    private int val;


    public Transaction2(String tong, int val) {
        this.tong = tong;
        this.val = val;
    }
}
