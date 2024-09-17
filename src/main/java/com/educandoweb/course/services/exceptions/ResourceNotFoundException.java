package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id "+id); //Exceção personalizada para o erro de busca de um ID não existente
	}
}
