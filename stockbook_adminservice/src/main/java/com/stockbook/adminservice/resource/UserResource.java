package com.stockbook.adminservice.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.domain.ErrorResponse;
import com.stockbook.adminservice.domain.Message;
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

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result,
			UriComponentsBuilder Builder) {

		if (result.hasErrors()) {

			return ResponseEntity.status(422).body(ErrorMessage(result.getAllErrors()));

		}

		else {
			userService.saveUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(Builder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUser(id);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

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
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		User user = userService.getUser(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.OK);

	}

	@RequestMapping(value = "/users/user/{id}", method = RequestMethod.PUT)
	public void blockUser(@PathVariable("id") Long id) {

		userService.blockUser(id);
	}

	@RequestMapping(value = "/users/user/{username}", method = RequestMethod.GET)
	public User getUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);

	}

	@RequestMapping(value = "/users/r-user/{username}", method = RequestMethod.GET)
	public List<Authorities> getRoles(@PathVariable("username") String username) {

		List<Authorities> rolesList = authoritiesService.getAllRoles(username);
		return rolesList;

	}

	private ErrorResponse ErrorMessage(List<ObjectError> allErrors) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<Message> messages = new ArrayList<Message>();
		allErrors.forEach(error -> {
			Message message = new Message();
			// message.setCode(error.getDefaultMessage().split("-")[0]);
			message.setMessage(error.getDefaultMessage());
			messages.add(message);
		});
		errorResponse.setError(true);
		errorResponse.setLevel("Error");
		errorResponse.setMessages(messages);
		return errorResponse;
	}

}
