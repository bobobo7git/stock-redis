package com.example.demo.stock.utils;

import com.example.demo.stock.dto.KisWebSocketHeaderDto;
import com.example.demo.stock.dto.KisWebSocketInputDto;
import com.example.demo.stock.dto.KisWebSocketSubMsg;
import com.example.demo.stock.dto.StockDto;
import com.example.demo.stock.entity.Stock;
import com.example.demo.stock.repository.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@ClientEndpoint
@Component
@Slf4j
@RequiredArgsConstructor
public class KisWebSocketClient {
    private Session session;
    private final KisOAuthClient authClient;
    private final StockRepository stockRepository;
    private final ObjectMapper objectMapper;

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

        String approvalKey = authClient.getWebSocketKey();
        List<StockDto> stocks = stockRepository.findAllAsDto();
        KisWebSocketHeaderDto headerDto = KisWebSocketHeaderDto.builder()
                .approvalKey(approvalKey)
                .custtype("P")
                .trType("1")
                .contentType("utf-8")
                .build();
    }
    @OnMessage
    public void onMessage(String message) {
        log.info(message);
    }
    @OnClose
    public void onClose(Session session) {
        this.session = null;
    }

    private void subscribe(Stock stock) {
        String approvalKey = authClient.getWebSocketKey();

    }
}
