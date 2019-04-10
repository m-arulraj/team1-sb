package com.stockbook.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockbook.adminservice.domain.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

}
