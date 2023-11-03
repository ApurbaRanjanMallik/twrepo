package com.springboot.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.junit.controller.MedicineController;
import com.springboot.junit.service.MedicineService;

@WebMvcTest(value = MedicineController.class)
public class MedicineAppTest {

	@MockBean
	MedicineService medicineService;
	@Autowired
	MockMvc mockMvc;

	@Test
	public void getHealthAdvice() {
		try {

			when(medicineService.getHealthAdvice()).thenReturn("Carry water and drink enough water");

			MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/medico/healthadv");

			MvcResult result = mockMvc.perform(request).andReturn();

			int status = result.getResponse().getStatus();

			assertEquals(200, status);

		} catch (Exception e) {
			System.out.println("Check the code you have written");
		}
	}
}
