package com.mcb.assessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
	@Autowired
	MockMvc mockMvc;

	String baseUrl = "/api/students";
	@Autowired
	ObjectMapper objectMapper;


	@Test
	void getStudentById () throws Exception {
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/").
						queryParam ("Id", "1")).
				andExpect (MockMvcResultMatchers.status ().isOk ());
	}

	@Test
	void failgetStudentById () throws Exception {
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/").
						queryParam ("Id", "100")).
				andExpect (MockMvcResultMatchers.status ().isNotFound ());
	}


	@Test
	void getMarksByStudentId () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id + "/marks")).
				andExpect (MockMvcResultMatchers.status ().isOk ()).andDo (print ()).andReturn ();
	}

	@Test
	void getListOfMarksByStudentId () {
	}

	@Test
	void addStudent () {
	}

	@Test
	void getStudentsByTeacherId () {
	}
}