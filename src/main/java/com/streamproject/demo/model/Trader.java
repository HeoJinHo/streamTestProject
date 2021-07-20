package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trader
{

    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
