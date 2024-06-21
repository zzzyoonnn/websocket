package com.websocket.chat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor    // Lombok을 사용하여 final 필드나 @NonNull 애노테이션이 있는 필드에 대해 생성자를 자동으로 생성
@Slf4j                      // Lombok을 사용하여 이 클래스에 로깅 기능을 추가
public class WebSocketEventListener {

    // 특정 이벤트를 수신하는 이벤트 리스너임을 나타내는 메서드
    // handleWebSocketDisconnectListener 메서드 : WebSocket의 세션이 끊어졌을 때 호출
    @EventListener
    public void handleWebSocketDisconnectListener(
            SessionDisconnectEvent event
    ) {
        // WebSocket 연결 해제 시 수행할 작업 구현
    }
}
