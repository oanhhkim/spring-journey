package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // cấu hình message broker
    // "/topic": prefix của các endpoint mà client subscribe
    config.enableSimpleBroker("/topic");

    // định nghĩa prefix cho các destination mà client sẽ gửi message tới WebSocket server.
    config.setApplicationDestinationPrefixes("/app");
  }

  // định nghĩa những endpoint client sử dụng để gọi và kết nối tới websocket
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    //    thêm endpoint mà mình muốn
    registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    //    registry.addEndpoint("/hello");
  }
}
