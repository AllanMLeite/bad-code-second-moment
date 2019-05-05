package br.com.cc.demo.api.exception;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.cc.demo.person.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RestResponseEntityExceptionHandlerTest {

	private static final String PEOPLE_URL = "/people";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	public void shouldHandleMethodArgumentNotValidException() throws Exception {

		String expectedMsg = "{\"message\":\"cpf cannot be blank\",\"status\":400,\"error\":\"Bad Request\"}";

		mockMvc.perform(post(PEOPLE_URL)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"joao\"}"))
		.andExpect(status().isBadRequest())
		.andExpect(content().string(expectedMsg));
	}
}