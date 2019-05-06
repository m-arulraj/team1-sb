package com.stockbook.adminservice.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.domain.User;
import com.stockbook.adminservice.service.AuthoritiesService;
import com.stockbook.adminservice.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

	@Autowired
	UserService userService;

	@Autowired
	AuthoritiesService authoritiesService;

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder Builder) throws URISyntaxException {

		User saveduser=userService.saveUser(user);


		return ResponseEntity.created(new URI("/api/user/" + saveduser.getId())).body(saveduser);

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

	@RequestMapping(value = "/users/user/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);

	}

	@RequestMapping(value = "/users/user/roles/{username}", method = RequestMethod.GET)
	public List<Authorities> getRoles(@PathVariable("username") String username) {

		List<Authorities> rolesList = authoritiesService.getAllRoles(username);
		return rolesList;

	}

	@RequestMapping(value = "/profit", method = RequestMethod.GET)
	public List<Double> profit() {
		List<Double> TotalCP = userService.getTotalCP();
		List<Double> TotalSP = userService.getTotalSP();
		List<Double> profit = new ArrayList<Double>();
		for (int i = 0; i < 12; i++) {
			Double res;
			
				res = (TotalSP.get(i) - TotalCP.get(i));
				profit.add(res);
			

		}
		return profit;
	}

}
