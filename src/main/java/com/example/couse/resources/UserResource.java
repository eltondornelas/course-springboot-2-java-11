package com.example.couse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	//Recursos web correspondente a User.
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		//retorna resposta de requisições web
		User u = new User(1L, "Maria", "maria@gmail", "999999", "12345");
		return ResponseEntity.ok().body(u);
		
	}
	
}
