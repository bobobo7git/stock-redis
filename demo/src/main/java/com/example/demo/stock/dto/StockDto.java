package com.example.demo.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private String stockCode;
    private String stockName;
    private int closingPrice;
    private Timestamp updatedAt;
}
