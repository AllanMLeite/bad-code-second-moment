package br.com.cc.demo.person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	public Person save(Person person) {
		// TODO save in the repository
		return person;
	}

}