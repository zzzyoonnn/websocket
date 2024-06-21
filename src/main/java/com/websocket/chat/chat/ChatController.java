package com.websocket.chat.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {       // WebSocket을 통해 채팅 메시지를 처리하는 컨트롤러


    // @MessageMapping : 클라이언트가 "/chat.sendMessage" 목적지로 보내는 메시지를 이 메서드가 처리하도록 하는 애노테이션
    // @SendTo : 이 메서드가 반환하는 메시지를 "/topic/public" 목적지로 브로드캐스트하도록 하는 애노테이션
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMassage(
            // @Payload : 전달된 메시지를 ChatMessage 객체로 변환
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }

    // @MessageMapping : 클라이언트가 "/chat.addUser" 목적지로 보내는 메시지를 이 메서드가 처리하도록 하는 애노테이션
    // @SendTo : 이 메서드가 반환하는 메시지를 "/topic/public" 목적지로 브로드캐스트하도록 하는 애노테이션
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket sesscion
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        // 클라이언트로부터 받은 ChatMessage 객체를 그대로 반환
        return chatMessage;
    }
}
