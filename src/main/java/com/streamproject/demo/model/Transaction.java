package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction
{

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }


    @Override
    public String toString() {
        return "{" +
                "trader=" + this.trader +
                ", year=" + this.year +
                ", value=" + this.value +
                '}';
    }
}
