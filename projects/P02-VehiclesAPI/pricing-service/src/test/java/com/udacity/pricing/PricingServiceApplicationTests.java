package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {


	@Autowired
	private MockMvc mvc;

	@Mock
	PricingService pricingService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPrice() throws Exception {


		mvc.perform(get("/services/price?vehicleId=1"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.vehicleId").value(1));


		verify(pricingService, times(1)).getPrice((long)1);
	}

}
