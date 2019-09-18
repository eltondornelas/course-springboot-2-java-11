package com.example.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.couse.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	//interface por conta do JPA
	//instancia objeto repository com várias operações para trabalhar com o usuário
	
	
}
