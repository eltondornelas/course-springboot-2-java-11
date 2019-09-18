package com.example.couse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.couse.entities.Order;
import com.example.couse.entities.User;
import com.example.couse.repositories.OrderRepository;
import com.example.couse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//fazendo o seeding
	//o nome do profile tem que ser igual ao que esta no application.properties
	
	@Autowired
	private UserRepository userRepository;
	//com o autowired o spring sabe da dependência e associa uma instancia ao userRepository automaticamente
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		//tudo que colocar dentro desse método vai executar quando a aplicação for iniciada

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		//id nulo para deixar automático pelo banco de dados		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); //z é padrão UTC de GreenWich
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); //no banco de dados o horário vai mostrar com -3 horas
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));		

	}
	
	
}
