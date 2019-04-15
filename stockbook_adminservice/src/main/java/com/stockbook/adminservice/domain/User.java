package com.stockbook.adminservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Pattern(regexp = "[^0-9]*", message = "invalid")
	@NotEmpty(message = "Name can’t be empty")
	@Column(name = "name")
	private String name;

	@Size(min = 3, max = 20, message = "Email id can't be empty")
	@Email(message = "Please enter a valid email")
	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private int contact;

	@Column(name = "enabled")
	private int enabled;

	@OneToOne
	@JoinColumn(name = "authorities_fk")
	private Authorities authorities;

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
