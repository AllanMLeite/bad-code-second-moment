package br.com.cc.demo.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		ObjectNode jsonNode = createBody(status, message);
		return ResponseEntity.status(status).body(jsonNode);
	}
		
	private ObjectNode createBody(HttpStatus status, String message) {
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();
		jsonNode.put("message", message);
		jsonNode.put("status", status.value());
		jsonNode.put("error", status.getReasonPhrase());
		return jsonNode;
	}
}