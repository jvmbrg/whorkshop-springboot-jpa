package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
/* Aqui no pacote serviços temos a classe ProductService que é responsavel por gerir os servi
 * ços dos usuarios. Atraves do sistema de camadas de funções, essa classe é a que fica encarre
 * gada de receber as solicitações do controller e fazer a busca dentro do banco de dados
 * (repository), como se fosse o meio termo entre elas.
 */

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	//Metodo responsavel por repassar a chamada do metodo findAll para a camada repository.
	public List<Product> findAll(){
		return repository.findAll();
	}
	// Meteodo reponsavel por repassar a chamada do metodo findById para a camada repository
	public Product findById(Long id) {
		//O comando "Optional e representa valores que podem ou não estar estar presentes na chamada, evitando erro de NullPointException" 
		Optional<Product> obj = repository.findById(id);
		return obj.get(); // o metodo get retorna um objeto do tipo Product que estiver dentro do Optional.
	}
}
