package br.com.cc.demo.api.person;

import br.com.cc.demo.person.Person;

public final class PersonResponseConverter {

	private PersonResponseConverter() {

	}
	
	public static PersonResponse convert(Person person) {
		return new PersonResponse(person.getId(), 
				person.getName(), 
				person.getCpf(), 
				person.getAge(),
				person.getHomePhones(), 
				person.getMobilePhones()); 
	}
}
