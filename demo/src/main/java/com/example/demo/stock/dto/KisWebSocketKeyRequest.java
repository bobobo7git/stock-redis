package com.example.demo.stock.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KisWebSocketKeyRequest {
    private String grantType;
    private String appkey;
    private String secretkey;
}
