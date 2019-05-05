package br.com.cc.demo.api.person;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class PersonRequest {

	@NotBlank(message = "name cannot be blank")
	private String name;
	@NotBlank(message = "cpf cannot be blank")
	private String cpf;
	private int age;
	private List<String> homePhones;
	private List<String> mobilePhones;

	public String getCpf() {
		return cpf;
	}

	public int getAge() {
		return age;
	}

	public List<String> getHomePhones() {
		return homePhones;
	}

	public List<String> getMobilePhones() {
		return mobilePhones;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonRequest [name=" + name + ", cpf=" + cpf + ", age=" + age + ", homePhones=" + homePhones
				+ ", mobilePhones=" + mobilePhones + "]";
	}
}
