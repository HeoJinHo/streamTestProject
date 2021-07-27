package com.streamproject.demo.controller;

import com.streamproject.demo.sv.Moveable;
import com.streamproject.demo.sv.Resizable;
import com.streamproject.demo.sv.Rotatable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public class Monster implements Rotatable, Moveable, Resizable {


    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void setRotationAngle(int angelInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }
}
