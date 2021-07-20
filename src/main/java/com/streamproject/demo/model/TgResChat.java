package com.streamproject.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TgResChat
{
    private long id;

    private String first_name;

    private String last_name;

    private String username;

    private String type;
}
