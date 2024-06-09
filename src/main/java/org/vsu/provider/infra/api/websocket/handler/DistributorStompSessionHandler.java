package org.vsu.provider.infra.api.websocket.handler;

import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class DistributorStompSessionHandler extends StompSessionHandlerAdapter {

    private static final String TEST_USER_ID = "12345";

    @Override
    public void afterConnected(StompSession session, @NonNull StompHeaders connectedHeaders) {
        session.send("/app/connection", TEST_USER_ID);

        session.subscribe("/queue/messages/" + TEST_USER_ID, new StompFrameHandler() {
            @Override
            public Type getPayloadType(@NonNull StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(@NonNull StompHeaders headers, Object payload) {
                // todo
            }
        });
    }

}
