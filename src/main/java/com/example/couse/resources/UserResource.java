package com.example.couse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entities.User;
import com.example.couse.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	//Recursos web correspondente a User.

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		//retorna resposta de requisições web
		//User u = new User(1L, "Maria", "maria@gmail", "999999", "12345");
		
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findByEntity(@PathVariable Long id) { //o anotation pathvariable é para ele considerar no id a url que será passada
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
