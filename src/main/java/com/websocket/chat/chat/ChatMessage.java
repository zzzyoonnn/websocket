package com.websocket.chat.chat;

import lombok.*;

import java.awt.*;
@Getter     // 클래스의 모든 필드에 대해 getter 메서드를 자동으로 생성
@Setter     // 클래스의 모든 필드에 대해 setter 메서드를 자동으로 생성
@AllArgsConstructor     // 클래스의 모든 필드를 매개변수로 갖는 생성자를 자동으로 생성
@NoArgsConstructor      // 매개변수가 없는 기본 생성자를 자동으로 생성
@Builder                // 빌더 패턴(가독성 좋고 유연하게 객체를 생성)을 자동으로 생성
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;
}
