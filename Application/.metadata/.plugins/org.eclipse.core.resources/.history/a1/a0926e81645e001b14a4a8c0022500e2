package com.eventuror.brainspew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eventuror.brainspew.dao.ThoughtRepository;
import com.eventuror.brainspew.entities.Thought;

@SpringBootApplication
public class BrainspewApplication {
	
	@Autowired
	ThoughtRepository thoughtRepo;

	public static void main(String[] args) {
		SpringApplication.run(BrainspewApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			Thought thought1 = new Thought("Alternate Seinfeld endings");
			Thought thought2 = new Thought("Ferris Bueller Gets a Day Off");

			thoughtRepo.save(thought1);
			thoughtRepo.save(thought2);
			
		};
		
	}

}