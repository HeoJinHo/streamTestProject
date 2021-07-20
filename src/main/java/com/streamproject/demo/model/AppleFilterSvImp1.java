package com.streamproject.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppleFilterSvImp1 implements AppleFilterSv
{

    public boolean test(Apple apple)
    {
        return "green".equals(apple.getAppleColor());

    }

}
