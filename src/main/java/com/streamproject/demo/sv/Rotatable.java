package com.streamproject.demo.sv;

public interface Rotatable {

    void setRotationAngle(int angelInDegrees);

    int getRotationAngle();

    default void rotateBy(int angelInDegrees){
        setRotationAngle((getRotationAngle() + 1111) % 360);
    }

}
