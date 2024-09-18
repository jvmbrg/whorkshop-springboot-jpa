package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // o metodo get retorna um objeto do tipo User que estiver dentro do Optional.
		//Agora ele tenta chamar o User a partir do ID, caso tenha algum erro, ele lança uma exceção definida, no caso, o ResourceNotFound
	}
	
	public User insert(User obj) { // Metodo para inserir no banco de dados um novo usuario
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		//User entity = repository.getReferenceById(id);
		User entity = findById(id); //Esse metodo ainda não vai no banco de dados resgatar a informação, apenas prepara o objeto e manipula ele 
		//para depois enviar para o banco de dados .
		
		//Foi necessario alterar o código para a chamada do método "findByID" pois ele estava rodando fora do hibernate em LazyLoad. 
		//Usando o findById o hibernate inicia completamente a entidade e todas as suas propriedas
		updateData(entity,obj);
		return repository.save(entity);
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
