package com.stockbook.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.domain.User;
import com.stockbook.adminservice.repository.AuthoritiesRepository;
import com.stockbook.adminservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthoritiesRepository authoritiesRepository;

	public User saveUser(User user) {

		Authorities authorities = saveAuthorites(user);
		user.setAuthorities(authorities);

		return userRepository.save(user);

	}

	public Authorities saveAuthorites(User user) {
		Authorities authorities = new Authorities();
		authorities.setUsername(user.getUsername());
		authorities.setRole("ROLE_" + user.getAuthorities().getRole());
		authoritiesRepository.save(authorities);
		return authorities;

	}

	public User getUser(Long id) {

		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public void deleteById(Long id) {

		userRepository.deleteById(id);

	}

	public void blockUser(Long id) {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			User userStatus = user.get();
			userStatus.setEnabled(0);

			userRepository.save(userStatus);
		}

	}

	public User getUserByUserName(String username) {

		User user = userRepository.findByUsername(username);
		return user;
	}

}
