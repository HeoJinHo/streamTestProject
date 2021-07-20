package com.streamproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TgResChatContainer
{
    private long message_id;

    private TgResFrom from;

    private TgResChat chat;

    private long date;

    private String text;
}
