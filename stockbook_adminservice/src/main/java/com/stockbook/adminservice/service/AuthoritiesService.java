package com.stockbook.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {

	@Autowired
	AuthoritiesRepository authoritiesRepository;

	public List<Authorities> getAllRoles(String username) {

		return authoritiesRepository.findAllByUserName(username);

	}

}
