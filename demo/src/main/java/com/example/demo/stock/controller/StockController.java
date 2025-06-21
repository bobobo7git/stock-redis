package com.example.demo.stock.controller;

import com.example.demo.stock.service.KisOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final KisOAuthClient client;

    @GetMapping("/key")
    public String test() {
        return client.getWebSocketKey();
    }
}
