package com.example.demo.stock.repository;

import com.example.demo.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
