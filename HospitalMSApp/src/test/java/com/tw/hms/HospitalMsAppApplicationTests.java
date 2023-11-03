package com.tw.hms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.yml")
class HospitalMsAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	/*
	 * Test save operation
	 * 
	 */
	@Test
	@DisplayName("TESTING DOCTOR SAVE OPERATION")
	@Order(1)
	@Disabled
	public void testCreateDoctor() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("http://localhost:1818/v1/api/doctor/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":18,\n" + "	\"docName\":\"Sudhanshu\",\n" + "	\"docQualif\":\"MBBS\",\n"
						+ "	\"docSpec\":\"Surgeon\",\n" + "	\"docDept\":\"Cardiologists\",\n"
						+ "	\"docAddrs\":\"Bhadrak, Odisha\",\n" + "	\"docContact\":\"9658688602\"}");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("CREATED")) {
			fail("STUDENT NOT CREATED");
		}
	}

	/*
	 * Test fetchOneDoctor operation
	 * 
	 */
	@Test
	@DisplayName("TESTING FETCH ONE DOCTOR OPERATION")
	@Order(2)
	@Disabled
	public void testFetchOneDoctor() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("http://localhost:1818/v1/api/doctor/getone/{id}", 3);

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

	@Test
	@DisplayName("TESTING FETCH ALL DOCTOR OPERATION")
	@Order(3)
	@Disabled
	public void testFetchAllDoctors() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:1818/v1/api/doctor/all");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}

	@Test
	@DisplayName("TESTING DELETE ONE DOCTOR OPERATION")
	@Order(4)
	@Disabled
	public void testDeleteOneDoctor() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.delete("http://localhost:1818/v1/api/doctor/delete/{id}", 5);

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}

	@Test
	@DisplayName("TESTING UPDATE ONE DOCTOR OPERATION")
	@Order(5)
	@Disabled
	public void testupdateOneDoctor() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("http://localhost:1818/v1/api/doctor/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":9,\n" + "	\"docName\":\"Sudhanshu\",\n" + "	\"docQualif\":\"MBBS\",\n"
						+ "	\"docSpec\":\"Surgeon\",\n" + "	\"docDept\":\"Neurologists\",\n"
						+ "	\"docAddrs\":\"Bhadrak, Odisha\",\n" + "	\"docContact\":\"9658688602\"}");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}

	@Test
	@DisplayName("TESTING UPDATE ONE DOCTOR OPERATION")
	@Order(6)

	public void testupdateDoctorById() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.patch("http://localhost:1818/v1/api/doctor/modify/{id}/{docDept}", 1, "Physiatrists");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}
}
