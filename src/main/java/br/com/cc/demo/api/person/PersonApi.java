package br.com.cc.demo.api.person;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cc.demo.person.Person;
import br.com.cc.demo.person.PersonConverter;
import br.com.cc.demo.person.PersonService;

@RestController
@RequestMapping("/people")
public class PersonApi {

	private final Logger log = LogManager.getLogger(getClass());
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonResponse> save(@RequestBody @Valid PersonRequest request) {

		log.info("received request to save person [{}]",  request);
		
		Person person = PersonConverter.convert(request);
		
		person = personService.save(person);
		
		PersonResponse personResponse = PersonResponseConverter.convert(person);
		
		log.info("saved person [{}]",  personResponse);
		
		return ResponseEntity.ok(personResponse);
	}
}
