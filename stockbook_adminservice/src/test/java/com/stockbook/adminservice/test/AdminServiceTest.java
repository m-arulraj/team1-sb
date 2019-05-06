package com.stockbook.adminservice.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.domain.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
public class AdminServiceTest {

	public MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void Setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	// @Test
	public void test() throws Exception {

		User user = new User();
		Authorities authorities = new Authorities();
		authorities.setRole("USER");
		authorities.setUsername(user.getUsername());
		user.setUsername("Mahesh");
		user.setPassword("Mahesh@987");
		user.setName("Mahesh P");
		user.setEmail("mahesh123@gmail.com");
		user.setContact(123456987l);
		user.setEnabled(1);
		user.setAuthorities(authorities);

		String uri = "/api/user/";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn()
				.getResponse().getHeader("Location").toString();

	}

	@Test
	public void getUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getAllUsers() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/users/")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	// @Test
	public void deleteUser() throws Exception {

		String uri = "/api/user/24";
		mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void blockUser() throws Exception {

		String uri = "/api/users/user/1";

		mockMvc.perform(MockMvcRequestBuilders.put(uri)).andExpect(MockMvcResultMatchers.status().isOk());

	}

}
