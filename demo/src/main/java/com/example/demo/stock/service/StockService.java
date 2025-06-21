package com.example.demo.stock.service;

import com.example.demo.stock.dto.StockDto;
import com.example.demo.stock.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    List<StockDto> getAllStocks();
}
