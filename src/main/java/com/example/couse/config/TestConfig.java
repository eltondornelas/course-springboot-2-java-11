package com.example.couse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.couse.entities.User;
import com.example.couse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//o nome do profile tem que ser igual ao que esta no application.properties
	
	@Autowired
	private UserRepository userRepository;
	//com o autowired o spring sabe da dependência e associa uma instancia ao userRepository automaticamente

	@Override
	public void run(String... args) throws Exception {
		//tudo que colocar dentro desse método vai executar quando a aplicação for iniciada

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		//id nulo para deixar automático pelo banco de dados
		
		userRepository.saveAll(Arrays.asList(u1, u2));

	}
	
	
}
