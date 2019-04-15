package com.virtusa.stockbook_biller_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.stockbook_biller_service.domain.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
