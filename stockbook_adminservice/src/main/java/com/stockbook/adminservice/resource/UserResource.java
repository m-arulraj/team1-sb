package com.stockbook.adminservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockbook.adminservice.domain.User;
import com.stockbook.adminservice.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user, UriComponentsBuilder Builder) {

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(Builder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.getUser(id);

		if (user.isPresent()) {

			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		}

		return new ResponseEntity<Optional<User>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {

		userService.deleteById(id);

	}

	@RequestMapping(value = "/users/user/{id}", method = RequestMethod.PUT)
	public void blockUser(@PathVariable("id") Long id) {

		userService.blockUser(id);
	}

}
