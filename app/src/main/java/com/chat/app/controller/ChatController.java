package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//controller will handle all the incoming messages sent by the frontend and broadcasts to all the clients
@Controller
public class ChatController {
//    MessageMapping - maps the websocket messages to the destinations
//    SendTo - it broadcasts the particular message to all clients who have subscribed
//   when any messages came from "/app/sendMessage" it broadcasts to "/topic/messages"
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message)
    {
        return message;
    }
//since the anme of the html file is chat.html i have to give @getmapping("chat")
    @GetMapping("/chat")
    public String chat()
    {
        return "chat";
    }

}
