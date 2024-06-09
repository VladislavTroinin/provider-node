package org.vsu.provider.infra.api.websocket.handler;

import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class CustomStompSessionHandler extends StompSessionHandlerAdapter {

    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private final String userId = "12345";

    @Override
    public void afterConnected(StompSession session, @NonNull StompHeaders connectedHeaders) {
        System.out.println("Connected to WebSocket server");

        session.send("/app/connection", userId);

        session.subscribe("/queue/messages/" + userId, new StompFrameHandler() {
            @Override
            public Type getPayloadType(@NonNull StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(@NonNull StompHeaders headers, Object payload) {
                boolean result = messageQueue.offer(payload.toString());
                System.out.println("Received message [by frame handler]: " + payload);
            }
        });
    }

    @Override
    public void handleFrame(@NonNull StompHeaders headers, Object payload) {
        System.out.println("Received message [by session handler]: " + payload);
    }

    public String getNext() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
