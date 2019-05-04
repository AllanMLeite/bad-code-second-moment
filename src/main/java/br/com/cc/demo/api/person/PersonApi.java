package br.com.cc.demo.api.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/people")
public class PersonApi {

	@GetMapping("report")
	@ApiOperation("Relatorio de pessoas")
	public ResponseEntity<String> report() {

		return ResponseEntity.ok("test");
	}
}
