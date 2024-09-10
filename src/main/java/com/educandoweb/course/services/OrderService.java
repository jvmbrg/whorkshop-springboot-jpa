package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	//Metodo responsavel por repassar a chamada do metodo findAll para a camada repository.
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	// Meteodo reponsavel por repassar a chamada do metodo findById para a camada repository
	public Order findById(Long id) {
		//O comando "Optional e representa valores que podem ou não estar estar presentes na chamada, evitando erro de NullPointException" 
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // o metodo get retorna um objeto do tipo User que estiver dentro do Optional.
	}
}
