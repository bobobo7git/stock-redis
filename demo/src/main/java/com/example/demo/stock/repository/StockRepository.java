package com.example.demo.stock.repository;

import com.example.demo.stock.dto.StockDto;
import com.example.demo.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT new com.example.demo.stock.dto.StockDto(s.stockCode, s.stockName, s.closingPrice, s.updatedAt) FROM Stock s")
    List<StockDto> findAllAsDto();
}
