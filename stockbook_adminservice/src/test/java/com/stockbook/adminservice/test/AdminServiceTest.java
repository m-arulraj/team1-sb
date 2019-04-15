package com.stockbook.adminservice.test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest {

	public MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	String uri = "/api/user";

	@Before
	public void Setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void a_saveValidUser() throws Exception {

		User user = new User();
		Authorities authorities = new Authorities();
		authorities.setRole("MANAGER");
		authorities.setUsername(user.getUsername());
		user.setUsername("Ajith123");
		user.setPassword("Ajith");
		user.setName("Ajith S");
		user.setEmail("Ajith@gmail.com");
		user.setContact(123456987);
		user.setEnabled(1);
		user.setAuthorities(authorities);

		String status = mockMvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(user)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location");

		mockMvc.perform(MockMvcRequestBuilders.get(status).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.id", is(2)));

	}

	@Test
	public void b_saveInValidUserByName() throws Exception {

		User user = new User();
		Authorities authorities = new Authorities();
		authorities.setRole("MANAGER");
		authorities.setUsername(user.getUsername());
		user.setUsername("Ajith123");
		user.setPassword("Ajith");
		user.setName("");
		user.setEmail("Ajith@gmail.com");
		user.setContact(123456987);
		user.setEnabled(1);
		user.setAuthorities(authorities);

		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))).andExpect(MockMvcResultMatchers.status().is(422));

	}

	@Test
	public void c_saveInValidUserByEmail() throws Exception {

		User user = new User();
		Authorities authorities = new Authorities();
		authorities.setRole("MANAGER");
		authorities.setUsername(user.getUsername());
		user.setUsername("Ajith123");
		user.setPassword("Ajith");
		user.setName("Ajith S");
		user.setEmail("A");
		user.setContact(123456987);
		user.setEnabled(1);
		user.setAuthorities(authorities);

		mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user))).andExpect(MockMvcResultMatchers.status().is(422));

	}

	@Test
	public void d_getUserByUserName() throws Exception {

		String URI = "/api/users/user/Ajith123";

		mockMvc.perform(MockMvcRequestBuilders.get(URI).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void e_getUserRoleByUserName() throws Exception {

		String URI = "/api/users/r-user/Ajith123";

		mockMvc.perform(MockMvcRequestBuilders.get(URI).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void f_getValidUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/2")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.id", is(2)));

	}

	@Test
	public void g_getInvalidUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/0"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void h_getAllUsers() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/users/")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void i_deleteUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/2")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void j_deleteInvalidUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/2"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void k_NoUsers() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/users/"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());

	}

	@Test
	public void l_blockUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.put("/api/users/user/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
