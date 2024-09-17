package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //Vai interceptar as exceções que acontecerem para que o objeto possa executar o tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) //Esse metedo intercepta qualquer exceção do tipo ResourceNotFound e executa o tratamento descrito dentro do metodo
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found"; //Define o texto que vai ser apresentado nesse erro em especifico 
		HttpStatus status = HttpStatus.NOT_FOUND; //Chama o metodo NOT_FOUND do http, error 404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); //Instância de um StandardError
		return ResponseEntity.status(status).body(err);
	}
}
