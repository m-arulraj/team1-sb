package com.stockbook.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockbook.adminservice.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
