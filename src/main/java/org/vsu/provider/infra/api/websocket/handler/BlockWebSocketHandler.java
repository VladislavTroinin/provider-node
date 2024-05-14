package org.vsu.provider.infra.api.websocket.handler;

import org.springframework.lang.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class BlockWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
        session.sendMessage(new TextMessage("hello!"));
    }

}
