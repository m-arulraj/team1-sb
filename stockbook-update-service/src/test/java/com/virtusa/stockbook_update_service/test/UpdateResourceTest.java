package com.virtusa.stockbook_update_service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.stockbook_update_service.domain.User;
import com.virtusa.stockbook_update_service.resource.UpdateResource;
import com.virtusa.stockbook_update_service.service.UpdateService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UpdateResourceTest {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webAppContect;

	@Mock
	UpdateService updateService;

	@InjectMocks
	UpdateResource updateResource;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}

	@Test
	public void testUpdateControllerForUpdatingPassword() throws Exception {
		User user = new User();
		user.setId(1l);
		user.setUsername("pavan8123");
		user.setPassword("sanjit");
		user.setNewpassword("pavan");
		user.setNewusername("kumar");

		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/api/user/updateuserpassword")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testUpdateControllerForUpdatingUserName() throws Exception {
		User user = new User();
		user.setId(1l);
		user.setUsername("kumar");
		user.setPassword("sanjit");
		user.setNewpassword("pavan");
		user.setNewusername("pavan8123");
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/user/updateusername")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void testUpdateControllerForUpdatingProfile() throws Exception {
		
		User user = new User();
		user.setId(1l);
		user.setUsername("kumar");
		user.setPassword("sanjit");
		user.setNewpassword("pavan");
		user.setNewusername("pavan8123");
		user.setContact(123456);
		user.setEmail("gsdhgdfgh");
		user.setEnabled(1);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/user/updateuserprofile")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
