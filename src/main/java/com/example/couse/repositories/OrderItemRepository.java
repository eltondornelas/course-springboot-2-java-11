package com.example.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.couse.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	//interface por conta do JPA
	//instancia objeto repository com várias operações para trabalhar com o usuário
	
	
}
