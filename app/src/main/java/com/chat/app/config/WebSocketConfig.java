package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        setting message broker to handle outgoing messages
        registry.enableSimpleBroker("/topic");
//        ensuring my message comes from /app
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
//  registerStompEndpoints() -  Define the URL where clients will connect via WebSocket.
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        The client must use this URL to connect to the WebSocket server
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
//        Set up CORS (Cross-Origin Resource Sharing) rules (so your frontend and backend can talk even if they’re on different ports/domains).
                .withSockJS();
    }
}
