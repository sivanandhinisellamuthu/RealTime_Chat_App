package com.chat.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

//this is the class that represents the particular message
@Data
@NoArgsConstructor
public class ChatMessage {
    private long id;
    private String sender;
    private String content;
}
