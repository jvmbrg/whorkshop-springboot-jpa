package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
//Classe especifica de configuração, não estando alocada em nenhuma categorai especifica

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Darmian Freuz","darmianf@gmail.com","98282-0909","123456" );
		User u2 = new User(null,"Azira Dort","azdort@gmail.com","99191-7574","654321"); 
		
		Order o1 = new Order(null, Instant.parse("2024-09-10T09:19:45Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-09-08T19:15:00Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-09-05T14:27:11Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
