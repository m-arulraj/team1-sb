
package com.virtusa.stockbook_biller_service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.virtusa.stockbook_biller_service.domain.Bill;

@RunWith(SpringRunner.class)

@SpringBootTest
 
@ActiveProfiles("test")

public class BillerApplicationIntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext applicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void testForSavingBill() throws Exception {
		Bill bill = new Bill();
		bill.setName("ramu");
		bill.setConatct(1236);
		bill.setGrandTotal(450.2);
		bill.setBillerName("gopi");
		bill.setBillDate("2018-01-11");
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/bill").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(bill))).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void testForGettingBillById() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/bill/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void negativeTestForGettingBillById() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/bill/99").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));
	}

	@Test
	public void testForGettingBillByBillerName() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/bill/biller/gopi").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void negativeTestForGettingBillByBillerName() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/bill/biller/pavan").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testForGettingBillByMonthlywise() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/bill/month/01").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void negativeTestForGettingBillByMonthlywise() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/bill/month/100").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	

}
