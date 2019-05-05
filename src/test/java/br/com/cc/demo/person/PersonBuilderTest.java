package br.com.cc.demo.person;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

public class PersonBuilderTest {

	@Test
	public void shouldCreatePerson() {
		Person person = new PersonBuilder()
			.withCpf("01234567890")
			.withAge(28)
			.withName("Arya")
			.withHomePhones(Collections.singletonList("12345678"))
			.withMobilePhones(Collections.singletonList("789456123"))
			.withId(22l)
			.build();
		
		assertEquals("01234567890", person.getCpf());
		assertEquals(28, person.getAge());
		assertEquals("Arya", person.getName());
		assertThat(person.getId()).isEqualTo(22l);
		assertThat(person.getHomePhones()).containsExactly("12345678");
		assertThat(person.getMobilePhones()).containsExactly("789456123");		
	}
}
