package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Pacote de resoluções web, responsavel por fazer as requisições referentes ao User.

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users") 
/* Aqui o "/users" é o caminho que vai exibir as informações do metodo findAll. Quando dermos o localhost:8080/users, será exibido um json com as informa
 * ções passadas por parametro dentro do metodo.*/


public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping //Esse método é um endpoint para acessar os usuarios.
	//O ResponseEntity é do tipo generico, por isso, precisamos definir qual o tipo do retorno.
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//Esse tipo de retorno ResponseEntity é especifico para retornar respostas de requisição WEB.
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
