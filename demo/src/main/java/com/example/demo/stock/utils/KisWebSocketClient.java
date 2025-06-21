package com.example.demo.stock.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;

@ClientEndpoint
@Component
@Slf4j
@RequiredArgsConstructor
public class KisWebSocketClient {
    private Session session;
    private KisOAuthClient authClient;
    private ObjectMapper objectMapper;
    public boolean isConnected() {
        return session != null && session.isOpen();
    }
    public void connect() throws Exception {
        URI uri = new URI("ws://ops.koreainvestment.com:21000");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(this, uri);
    }
    @OnOpen
    public void onOpen(Session session) {
        log.info("kis websocket session opened");
        this.session = session;
    }
    @OnMessage
    public void onMessage(String message) {
        log.info(message);
    }
    @OnClose
    public void onClose(Session session) {
        this.session = null;
    }
    private void subscribe(String code) {

    }
}
