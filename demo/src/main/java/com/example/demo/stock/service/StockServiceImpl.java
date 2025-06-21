package com.example.demo.stock.service;

import com.example.demo.stock.entity.Stock;
import com.example.demo.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}
