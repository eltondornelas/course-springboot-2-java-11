package com.example.couse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entities.Category;
import com.example.couse.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	//Recursos web correspondente a Category.

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		//retorna resposta de requisições web
		//Category u = new Category(1L, "Maria", "maria@gmail", "999999", "12345");
		
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findByEntity(@PathVariable Long id) { //o anotation pathvariable é para ele considerar no id a url que será passada
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
