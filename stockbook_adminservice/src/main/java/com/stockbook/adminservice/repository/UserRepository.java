package com.stockbook.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockbook.adminservice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
