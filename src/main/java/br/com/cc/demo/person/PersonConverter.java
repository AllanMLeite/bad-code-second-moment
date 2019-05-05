package br.com.cc.demo.person;

import br.com.cc.demo.api.person.PersonRequest;

public final class PersonConverter {

	private PersonConverter() {

	}

	public static Person convert(PersonRequest request) {
		return new PersonBuilder()
				.withCpf(request.getCpf())
				.withName(request.getName())
				.withAge(request.getAge())
				.withHomePhones(request.getHomePhones())
				.withMobilePhones(request.getMobilePhones())
				.build();
	}

}
