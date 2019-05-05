package br.com.cc.demo.api.person;

import java.util.List;

public class PersonResponse {

	private final Long id;
	private final String name;
	private final String cpf;
	private final int age;
	private final List<String> homePhones;
	private final List<String> mobilePhones;

	public PersonResponse(Long id, String name, String cpf, int age, List<String> homePhones,
			List<String> mobilePhones) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.homePhones = homePhones;
		this.mobilePhones = mobilePhones;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public List<String> getHomePhones() {
		return homePhones;
	}
	
	public List<String> getMobilePhones() {
		return mobilePhones;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonResponse [id=" + id + ", name=" + name + ", cpf=" + cpf + ", age=" + age + ", homePhones="
				+ homePhones + ", mobilePhones=" + mobilePhones + "]";
	}
}
