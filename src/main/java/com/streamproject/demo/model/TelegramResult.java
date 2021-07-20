package com.streamproject.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TelegramResult<T>
{
    /**
     * 결과
     */
    private boolean ok;

    /**
     * 결과값
     */
    private T result;
}
