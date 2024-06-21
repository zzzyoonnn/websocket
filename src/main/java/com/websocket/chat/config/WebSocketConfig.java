package com.websocket.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {      // WebSocket 메시지 브로커 설정을 담당

    // STOMP 엔드포인트를 등록하는 메서드
    // 클라이언트가 WebSocket에 연결할 때 사용할 엔드포인트를 설정
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // "/chat" 엔드포인트를 등록하고 SockJS를 사용하도록 설정
        // SockJS : WebSocket을 지원하지 않는 브라우저에서 대체 전송 프로토콜을 사용할 수 있게 함
        registry.addEndpoint("/chat").withSockJS();
    }

    // 메시지 브로커를 구성하는 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 애플리케이션 목적지 접두사 설정
        // 클라이언트가 메시지를 보낼 때 사용되는 접두사
        registry.setApplicationDestinationPrefixes("/app");

        // 간단한 메시지 브로커를 활성화
        // "/topic" 접두사가 붙은 목적지로 메시지를 브로드캐스팅
        registry.enableSimpleBroker("/topic");
    }
}
