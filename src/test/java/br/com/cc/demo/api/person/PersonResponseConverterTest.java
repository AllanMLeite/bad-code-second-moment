package br.com.cc.demo.api.person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import br.com.cc.demo.person.Person;
import br.com.cc.demo.person.PersonBuilder;

public class PersonResponseConverterTest {
	
	@Test
	public void shouldCreatePersonResponse() {
		Person person = new PersonBuilder()
			.withCpf("01234567890")
			.withAge(28)
			.withName("Arya")
			.withHomePhones(Collections.singletonList("12345678"))
			.withMobilePhones(Collections.singletonList("789456123"))
			.withId(22l)
			.build();
		
		PersonResponse personResponse = PersonResponseConverter.convert(person);
		
		assertEquals("01234567890", personResponse.getCpf());
		assertEquals(28, personResponse.getAge());
		assertEquals("Arya", personResponse.getName());
		assertThat(personResponse.getId()).isEqualTo(22l);
		assertThat(personResponse.getHomePhones()).containsExactly("12345678");
		assertThat(personResponse.getMobilePhones()).containsExactly("789456123");		
	}
}
