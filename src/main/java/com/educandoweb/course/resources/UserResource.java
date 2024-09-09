package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Pacote de resoluções web, responsavel por fazer as requisições referentes ao User.

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users") 
/* Aqui o "/users" é o caminho que vai exibir as informações do metodo findAll. Quando dermos o localhost:8080/users, será exibido um json com as informa
 * ções passadas por parametro dentro do metodo.*/
public class UserResource {
	
	@GetMapping //Esse método é um endpoint para acessar os usuarios.
	//O ResponseEntity é do tipo generico, por isso, precisamos definir qual o tipo do retorno.
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "71982166003", "123456");
		return ResponseEntity.ok().body(u);
		//Esse tipo de retorno ResponseEntity é especifico para retornar respostas de requisição WEB.
	}

}
