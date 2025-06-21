package com.example.demo.stock.dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KisWebSocketBodyDto {
    private KisWebSocketInputDto input;
}
