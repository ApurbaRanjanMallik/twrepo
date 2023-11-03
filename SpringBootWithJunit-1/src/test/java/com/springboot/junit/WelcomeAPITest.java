package com.springboot.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.junit.api.WelcomeAPI;
import com.springboot.junit.model.User;
import com.springboot.junit.service.WelcomeService;

/*
 * Annotation that can be used for a Spring MVC test that focuses only on
 * Spring MVC components
 * Using this annotation will disable full auto-configuration and instead apply only
 * configuration relevant to MVC tests 
 * (i.e. @Controller, @ControllerAdvice, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver beans but not @Component, @Service or @Repository beans). 
 */
@WebMvcTest(value = WelcomeAPI.class)
public class WelcomeAPITest {

	/*
	 * Annotation that can be used to add mocks to a Spring ApplicationContext
	 */
	@MockBean
	WelcomeService welcomeService;

	/*
	 * Main entry point for server-side Spring MVC test support.
	 */
	@Autowired
	MockMvc mockMvc;

	@Test
	public void getWelcomeTest() {
		try {

			when(welcomeService.getWelcomeMsg()).thenReturn("Welcome to Test");

			MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/welcome");

			MvcResult result = mockMvc.perform(request).andReturn();

			int status = result.getResponse().getStatus();

			assertEquals(200, status);

		} catch (Exception e) {
			System.out.println("Check the code you have written");
		}
	}

	@Test
	public void addUserTest() {

		User user = new User();
		user.setUserId(1011);
		user.setUserName("A");
		user.setEmail("a@gmail.com");

		when(welcomeService.addUser(any())).thenReturn(true);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String userJson = objectMapper.writeValueAsString(user);

			MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/user/add")
					.contentType("application/json").content(userJson);
			MvcResult result = mockMvc.perform(request).andReturn();

			String actual = result.getResponse().getContentAsString();

			assertEquals("User added", actual);
		} catch (Exception e) {
			System.out.println("Check the code you have written");
		}

	}

}
