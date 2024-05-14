package org.vsu.provider.infra.api.websocket.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.DependsOn;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Deprecated
public class BlockWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
        Object answer = new Object();
        sendAnswer(session, answer);
    }

    private void sendAnswer(WebSocketSession session, Object answer) throws IOException {
        try {
            String answerJSON = new JsonMapper().writeValueAsString(answer);
            session.sendMessage(new TextMessage(answerJSON));
        } catch (JsonProcessingException e) {
            session.close(CloseStatus.SERVER_ERROR);
        }
    }



}
