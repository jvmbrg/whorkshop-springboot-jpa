package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Pacote de resoluções web, responsavel por fazer as requisições referentes ao Product.

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

/* Aqui o "/users" é o caminho que vai exibir as informações do metodo findAll. Quando dermos o localhost:8080/users, será exibido um json com as informa
 * ções passadas por parametro dentro do metodo.*/
@RestController
@RequestMapping(value = "/products") 
public class ProductResource {
	@Autowired
	private ProductService service;
	
	//Esse método é um endpoint para acessar os usuarios.
	//O ResponseEntity é do tipo generico, por isso, precisamos definir qual o tipo do retorno.
	@GetMapping 
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//Esse tipo de retorno ResponseEntity é especifico para retornar respostas de requisição WEB.
	}
	
	//Aqui, o metodo retorna um usuario com base no id do cadastro.
	@GetMapping(value="/{id}")
	public ResponseEntity <Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
