package com.example.couse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entities.Product;
import com.example.couse.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	//Recursos web correspondente a Product.

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		//retorna resposta de requisições web
		//Product u = new Product(1L, "Maria", "maria@gmail", "999999", "12345");
		
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findByEntity(@PathVariable Long id) { //o anotation pathvariable é para ele considerar no id a url que será passada
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
