package org.vsu.provider.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.vsu.provider.infra.api.websocket.handler.DistributorStompSessionHandler;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Configuration
public class WebSocketConfig {

    private static final String DISTRIBUTOR_URL = "ws://localhost:8080/ws";

    @Bean
    public StompSession stompSession() throws ExecutionException, InterruptedException {
        List<Transport> transports = List.of(new WebSocketTransport(new StandardWebSocketClient()));
        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient client = new WebSocketStompClient(sockJsClient);
        client.setMessageConverter(new StringMessageConverter());

        return client.connectAsync(DISTRIBUTOR_URL, new DistributorStompSessionHandler()).get();
    }

}
