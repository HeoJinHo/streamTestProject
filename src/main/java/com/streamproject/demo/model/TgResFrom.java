package com.streamproject.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TgResFrom
{
    private long id;

    private boolean is_bot;

    private String first_name;

    private String last_name;

    private String username;

    private String language_code;
}
