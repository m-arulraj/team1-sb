package com.stockbook.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockbook.adminservice.domain.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
