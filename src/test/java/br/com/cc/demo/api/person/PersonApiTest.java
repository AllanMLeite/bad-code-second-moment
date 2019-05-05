package br.com.cc.demo.api.person;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Collections;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.cc.demo.person.Person;
import br.com.cc.demo.person.PersonService;
import br.com.cc.demo.util.ResourceUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonApi.class)
public class PersonApiTest {

	private static final String PEOPLE_URL = "/people";
	
	private static final String PEOPLE_JSON_BASE_DIR = "json/person/";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonService service;

	@Test
	public void shouldCreatePerson() throws Exception {
		Person newPerson = new Person(null, "Joao da Silva", "01234567890", 28, Collections.singletonList("0123456"),
				Collections.singletonList("9876567543"));
		
		Person mockSavedPerson = new Person(1l, "Joao da Silva", "01234567890", 28, Collections.singletonList("0123456"),
				Collections.singletonList("9876567543"));

		Mockito.when(service.save(Mockito.refEq(newPerson))).thenReturn(mockSavedPerson);

		String requestBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "sampleRequest.json");

		String expectedResponseBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "sampleResponse.json");

		mvc.perform(MockMvcRequestBuilders.post(PEOPLE_URL)
	    	  .accept(MediaType.APPLICATION_JSON)
	    	  .content(requestBody)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isOk())
			  .andExpect(content().json(expectedResponseBody));
	}
	
	@Test
	public void shouldThrowErrorWhenNameIsNull() throws Exception {

		String requestBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "requestWithNullName.json");

		mvc.perform(MockMvcRequestBuilders.post(PEOPLE_URL)
	    	  .accept(MediaType.APPLICATION_JSON)
	    	  .content(requestBody)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isBadRequest())
			  .andExpect(content().string(Matchers.containsString("name cannot be blank")));
	}
	
	@Test
	public void shouldThrowErrorWhenNameIsEmpty() throws Exception {

		String requestBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "requestWithEmptyName.json");

		mvc.perform(MockMvcRequestBuilders.post(PEOPLE_URL)
	    	  .accept(MediaType.APPLICATION_JSON)
	    	  .content(requestBody)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isBadRequest())
			  .andExpect(content().string(Matchers.containsString("name cannot be blank")));
	}
	
	@Test
	public void shouldThrowErrorWhenCpfIsNull() throws Exception {

		String requestBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "requestWithNullCpf.json");

		mvc.perform(MockMvcRequestBuilders.post(PEOPLE_URL)
	    	  .accept(MediaType.APPLICATION_JSON)
	    	  .content(requestBody)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isBadRequest())
			  .andExpect(content().string(Matchers.containsString("cpf cannot be blank")));
	}
	
	@Test
	public void shouldThrowErrorWhenCpfIsEmpty() throws Exception {

		String requestBody = ResourceUtils.loadResourceAsString(PEOPLE_JSON_BASE_DIR + "requestWithEmptyCpf.json");

		mvc.perform(MockMvcRequestBuilders.post(PEOPLE_URL)
	    	  .accept(MediaType.APPLICATION_JSON)
	    	  .content(requestBody)
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.status().isBadRequest())
			  .andExpect(content().string(Matchers.containsString("cpf cannot be blank")));
	}
}
