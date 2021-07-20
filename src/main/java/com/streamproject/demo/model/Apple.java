package com.streamproject.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apple
{

    String appleColor;

    int appleWeigth;

    public Apple(String appleColor, int appleWeigth) {
        this.appleColor = appleColor;
        this.appleWeigth = appleWeigth;
    }


    public Apple() {

    }
}


