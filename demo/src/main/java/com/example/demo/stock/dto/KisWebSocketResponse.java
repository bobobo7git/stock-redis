package com.example.demo.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KisWebSocketResponse {
    @JsonProperty("approval_key")
    private String approvalKey;
}
