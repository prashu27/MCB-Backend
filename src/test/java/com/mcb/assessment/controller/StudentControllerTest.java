package com.mcb.assessment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
class StudentControllerTest {
	@Autowired
	MockMvc mockMvc;

	String baseUrl = "/api/students";

	@Test
	void getStudentById () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id).header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")
				).
				andExpect (MockMvcResultMatchers.status ().isOk ());
	}

	@Test
	void failgetStudentById () throws Exception {
		long id = 100l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id).header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")
				).
				andExpect (MockMvcResultMatchers.status ().isNotFound ());
	}


	@Test
	void getMarksByStudentId () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id + "/marks").header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")).

				andExpect (MockMvcResultMatchers.status ().isOk ()).andDo (print ()).andReturn ();
	}

	@Test
	void GetMarksByStudentId () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id + "/marks").header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")).
				andExpect (MockMvcResultMatchers.status ().isOk ()).andDo (print ()).andReturn ();
	}

	@Test
	void failGetMarksByStudentId () throws Exception {
		long id = 100l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id + "/marks").header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")).
				andExpect (MockMvcResultMatchers.status ().isNotFound ()).andDo (print ()).andReturn ();
	}

	@Test
	void getListOfMarksByStudentId () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/" + id + "/subjects/marks").header ("Authorization"
						, "Bearer eyJhbGciOiJIUzI1NiJ9" +
								".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")).andExpect (
						MockMvcResultMatchers.status ().isOk ()).
				andExpect (MockMvcResultMatchers.jsonPath ("$.[1].mark").value ("10.0")
				).andDo (print ());

	}

	@Test
	void getStudentsByTeacherId () throws Exception {
		long id = 1l;
		mockMvc.perform (MockMvcRequestBuilders.get (baseUrl + "/teachers/" + id).header ("Authorization"
				, "Bearer eyJhbGciOiJIUzI1NiJ9" +
						".eyJzdWIiOiJwcmFzaGFuc2EiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2NzIyNjc2NiwiZXhwIjoxNjY3MjQ0NzY2fQ.fKpZwQO6o1_jVM7K6sAU7YczimiX6yImEKsp1M7q7IU")).andExpect (
				MockMvcResultMatchers.status ().isOk ()).andDo (print ());


	}
}