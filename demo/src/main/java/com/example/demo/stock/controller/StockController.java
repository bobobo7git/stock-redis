package com.example.demo.stock.controller;

import com.example.demo.stock.entity.Stock;
import com.example.demo.stock.service.StockService;
import com.example.demo.stock.utils.KisOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final KisOAuthClient client;
    private final StockService stockService;

    @GetMapping("/key")
    public String test() {
        return client.getWebSocketKey();
    }

    @GetMapping("/stocks")
    public List<Stock> all() {
        return stockService.getAllStocks();
    }
}
