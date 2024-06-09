package org.vsu.provider.infra.api.websocket.provider;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;
import org.vsu.provider.infra.api.websocket.handler.CustomStompSessionHandler;

import java.util.concurrent.CompletableFuture;

@Component
@AllArgsConstructor
public class WebSocketDistributorProvider {

    private final StompSession stompSession;
    private final CustomStompSessionHandler sessionHandler;

    @SneakyThrows
    public String sendRequest(String destination, Object payload) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        stompSession.send(destination, payload);

        new Thread(() -> {
            try {
                String message = sessionHandler.getNext();
                completableFuture.complete(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return completableFuture.get();
    }

}
