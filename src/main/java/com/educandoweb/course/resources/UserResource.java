package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Pacote de resoluções web, responsavel por fazer as requisições referentes ao User.
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

/* Aqui o "/users" é o caminho que vai exibir as informações do metodo findAll. Quando dermos o localhost:8080/users, será exibido um json com as informa
 * ções passadas por parametro dentro do metodo.*/
@RestController
@RequestMapping(value = "/users") 
public class UserResource {
	@Autowired
	private UserService service;
	
	//Esse método é um endpoint para acessar os usuarios.
	//O ResponseEntity é do tipo generico, por isso, precisamos definir qual o tipo do retorno.
	@GetMapping 
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		//Esse tipo de retorno ResponseEntity é especifico para retornar respostas de requisição WEB.
	}
	
	//Aqui, o metodo retorna um usuario com base no id do cadastro.
	@GetMapping(value="/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//Comando para criar uma URI com uma requisição HTTP de inserção de novo usuário no banco de dados.
		//A partir do mapping "/users" o obj uri vai incrementar o ID do novo usuario retornado ao objeto obj pelo metodo insert 
		//Fazendo assim, a requisição de inclusão retorna o codigo 201 que é o ideal para inserção de dados em um banco de dados
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); // Metedo noContent vai restornar uma resposta vazia com o codigo http 204
	}

}
