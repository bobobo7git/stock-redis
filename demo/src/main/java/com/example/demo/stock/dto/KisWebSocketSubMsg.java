package com.example.demo.stock.dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KisWebSocketSubMsg {
    private KisWebSocketHeaderDto header;
    private KisWebSocketBodyDto body;
}
