package com.example.demo.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KisWebSocketInputDto {
    @JsonProperty("tr_id")
    private String trId;

    @JsonProperty("tr_key")
    private String trKey;
}
