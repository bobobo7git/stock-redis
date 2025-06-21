package com.example.demo.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KisWebSocketHeaderDto {
    @JsonProperty("approval_key")
    private String approvalKey;

    private String custtype;

    @JsonProperty("tr_type")
    private String trType;

    @JsonProperty("content-type")
    private String contentType;
}
