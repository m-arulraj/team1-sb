package com.virtusa.clientapplication.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.Authorities;
import com.virtusa.clientapplication.domain.User;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		ResponseEntity<User> response = null;
		String name = authentication.getName();
		String password = (String) authentication.getCredentials();

		String uri = "http://localhost:8080/api/users/user" + name;

		response = restTemplate.getForEntity(uri, User.class);

		User user = response.getBody();
		
		if (!user.getUsername().equalsIgnoreCase(name)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		  ResponseEntity<List<Authorities>> roleResponse = restTemplate.exchange(uri+"/roles/"+name,HttpMethod.GET,null,new ParameterizedTypeReference<List<Authorities>>() {
		});
		   
		  List<Authorities> roles = roleResponse.getBody();
		  Collection<? extends GrantedAuthority> authorities  = roles;

			return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return true;
	}

}
