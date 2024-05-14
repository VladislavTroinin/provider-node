package org.vsu.provider.infra.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.vsu.provider.infra.api.websocket.handler.BlockWebSocketHandler;

//@Configuration
//@EnableWebSocket
//public class WebSocketConfig2 implements WebSocketConfigurer {
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(webSocketHandler(), "/ws");
//    }
//
//    @Bean
//    public WebSocketHandler webSocketHandler() {
//        return new BlockWebSocketHandler();
//    }
//
//}
