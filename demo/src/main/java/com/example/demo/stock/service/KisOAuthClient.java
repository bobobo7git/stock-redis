package com.example.demo.stock.service;

import com.example.demo.stock.dto.KisWebSocketKeyRequest;
import com.example.demo.stock.dto.KisWebSocketResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class KisOAuthClient {
    private String approvalKey;
    private final WebClient webClient;
    private static final String BASE_URL = "https://openapi.koreainvestment.com";
    private static final int PORT = 9443;   // 실전투자계좌포트
    public String getWebSocketKey() {
        if (approvalKey != null) return approvalKey;

        String endPoint = "/oauth2/Approval";
        String grantType = "client_credentials";
        String appkey = System.getProperty("KIS_APP_KEY");
        String secretkey = System.getProperty("KIS_APP_SECRET");

        KisWebSocketKeyRequest request = KisWebSocketKeyRequest.builder()
                .grantType(grantType)
                .appkey(appkey)
                .secretkey(secretkey)
                .build();
        log.info("websocket key api request");
        KisWebSocketResponse response = webClient.post()
                .uri(BASE_URL+":"+PORT+endPoint)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(KisWebSocketResponse.class)
                .block();

        return approvalKey = response.getApprovalKey();
    }
}
