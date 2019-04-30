package com.virtusa.clientapplication.config;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.Authorities;
import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.util.*;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider, AuthenticationSuccessHandler {

	@Autowired
	RestTemplate restTemplate;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		ResponseEntity<User> response = null;
		String name = authentication.getName();
		String password = (String) authentication.getCredentials();

		response = restTemplate.getForEntity(EndPointConstant.ADMIN_SERVICE_URI +"users/user/"+ name, User.class);

		User user = response.getBody();

		if (!user.getUsername().equalsIgnoreCase(name)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		if(user.getEnabled()==0) {
			throw new BadCredentialsException("UserBlocked");
		}

		ResponseEntity<List<Authorities>> roleResponse = restTemplate.exchange(
				EndPointConstant.ADMIN_SERVICE_URI + "users/user/roles/" + name, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Authorities>>() {
				});

		List<Authorities> roles = roleResponse.getBody();
		Collection<? extends GrantedAuthority> authorities = roles;

		return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return true;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)

			throws IOException, ServletException {

		boolean hasAdminRole = false;
		boolean hasManagerRole = false;
		boolean hasBillerRole = false;

		Collection<? extends GrantedAuthority> authoritires = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authoritires) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				hasAdminRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_BILLER")) {
				hasBillerRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("MANAGER")) {
				hasManagerRole = true;
				break;
			}

		}

		if (hasAdminRole) {
			redirectStrategy.sendRedirect(req, resp, "/admin");
		} else if (hasBillerRole) {
			redirectStrategy.sendRedirect(req, resp, "/biller");
		} else if (hasManagerRole) {
			redirectStrategy.sendRedirect(req, resp, "/manager");
		} else {
			throw new IllegalStateException();
		}
	}

}
