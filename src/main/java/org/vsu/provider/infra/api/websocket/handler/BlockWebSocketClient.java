package org.vsu.provider.infra.api.websocket.handler;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Deprecated
public class BlockWebSocketClient implements WebSocketClient {

    @NonNull
    @Override
    public CompletableFuture<WebSocketSession> execute(@NonNull WebSocketHandler webSocketHandler,
                                                       @NonNull String uriTemplate,
                                                       @NonNull Object... uriVariables) {
        return null;
    }

    @NonNull
    @Override
    public CompletableFuture<WebSocketSession> execute(@NonNull WebSocketHandler webSocketHandler,
                                                       @Nullable WebSocketHttpHeaders headers,
                                                       @NonNull URI uri) {
        return null;
    }

}
