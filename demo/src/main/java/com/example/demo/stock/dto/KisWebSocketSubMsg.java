package com.example.demo.stock.dto;

import lombok.Data;

@Data
public class KisWebSocketSubMsg {
    private KisWebSocketHeaderDto header;
    private KisWebSocketBodyDto body;
}
