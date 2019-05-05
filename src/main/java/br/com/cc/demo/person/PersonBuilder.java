package br.com.cc.demo.person;

import java.util.ArrayList;
import java.util.List;

public class PersonBuilder {

	private Long id;
	private String name;
	private String cpf;
	private int age;
	private List<String> homePhones = new ArrayList<String>();
	private List<String> mobilePhones = new ArrayList<String>();

	public PersonBuilder() {
		homePhones = new ArrayList<String>();
		mobilePhones = new ArrayList<String>();
	}

	public PersonBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PersonBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public PersonBuilder withCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public PersonBuilder withAge(int age) {
		this.age = age;
		return this;
	}

	public PersonBuilder withHomePhones(List<String> homePhones) {
		this.homePhones = homePhones;
		return this;
	}

	public PersonBuilder withMobilePhones(List<String> mobilePhones) {
		this.mobilePhones = mobilePhones;
		return this;
	}

	public Person build() {
		return new Person(id, name, cpf, age, homePhones, mobilePhones);
	}
}
