package com.example.couse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entities.Order;
import com.example.couse.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	//Recursos web correspondente a Order.

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {		
		
		List<Order> list = service.findAll(); 
		return ResponseEntity.ok().body(list);		
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findByEntity(@PathVariable Long id) { //o anotation pathvariable é para ele considerar no id a url que será passada
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
