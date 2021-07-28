package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Builder
{

    String name;

    String addr;

    int total;

    public Builder(String name, String addr, int total) {
        this.name = name;
        this.addr = addr;
        this.total = total;
    }
}
