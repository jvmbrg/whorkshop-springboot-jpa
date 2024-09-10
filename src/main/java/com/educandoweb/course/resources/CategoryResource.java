package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Pacote de resoluções web, responsavel por fazer as requisições referentes ao Category.

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

/* Aqui o "/users" é o caminho que vai exibir as informações do metodo findAll. Quando dermos o localhost:8080/users, será exibido um json com as informa
 * ções passadas por parametro dentro do metodo.*/
@RestController
@RequestMapping(value = "/categories") 
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	//Esse método é um endpoint para acessar os usuarios.
	//O ResponseEntity é do tipo generico, por isso, precisamos definir qual o tipo do retorno.
	@GetMapping 
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//Esse tipo de retorno ResponseEntity é especifico para retornar respostas de requisição WEB.
	}
	
	//Aqui, o metodo retorna um usuario com base no id do cadastro.
	@GetMapping(value="/{id}")
	public ResponseEntity <Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
