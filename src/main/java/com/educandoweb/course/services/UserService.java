package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
/* Aqui no pacote serviços temos a classe UserService que é responsavel por gerir os servi
 * ços dos usuarios. Atraves do sistema de camadas de funções, essa classe é a que fica encarre
 * gada de receber as solicitações do controller e fazer a busca dentro do banco de dados
 * (repository), como se fosse o meio termo entre elas.
 */

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	//Metodo responsavel por repassar a chamada do metodo findAll para a camada repository.
	public List<User> findAll(){
		return repository.findAll();
	}
	// Meteodo reponsavel por repassar a chamada do metodo findById para a camada repository
	public User findById(Long id) {
		//O comando "Optional e representa valores que podem ou não estar estar presentes na chamada, evitando erro de NullPointException" 
		Optional<User> obj = repository.findById(id);
		return obj.get(); // o metodo get retorna um objeto do tipo User que estiver dentro do Optional.
	}
}
