package com.SeeWeDemo.webSocketMessaging.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.SeeWeDemo.webSocketMessaging.model.Message;
import com.SeeWeDemo.webSocketMessaging.model.OutputMessage;

@Controller
public class WebsocketSendToUserController {
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
