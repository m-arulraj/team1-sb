package com.stockbook.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockbook.adminservice.domain.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

	@Query("Select a from Authorities a where a.username=:username")
	public List<Authorities> findAllByUserName(@Param("username") String username);

}
