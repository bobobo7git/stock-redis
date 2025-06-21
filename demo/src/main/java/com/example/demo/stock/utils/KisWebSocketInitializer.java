package com.example.demo.stock.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KisWebSocketInitializer {
    private final KisWebSocketClient webSocketClient;
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        try {
            if (!webSocketClient.isConnected()) {
                webSocketClient.connect();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }
}
