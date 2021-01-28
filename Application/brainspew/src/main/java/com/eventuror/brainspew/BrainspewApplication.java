package com.eventuror.brainspew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eventuror.brainspew.dao.ThoughtRepository;
import com.eventuror.brainspew.entities.Thought;
import com.eventuror.brainspew.entities.ThoughtParent;
import com.eventuror.brainspew.relationships.ThoughtParentId;

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
			Thought thought3 = new Thought("George gets hit by a bus");
			ThoughtParentId tp1 = new ThoughtParentId(1, 1);
			ThoughtParentId tp2 = new ThoughtParentId(2, 2);
			ThoughtParentId tp3 = new ThoughtParentId(3, 3);
			ThoughtParentId tp4 = new ThoughtParentId(1, 3);

			thoughtRepo.save(thought1);
			thoughtRepo.save(thought2);
//			thoughtRepo.save(tp1);
//			thoughtRepo.save(tp2);
//			thoughtRepo.save(tp3);
//			thoughtRepo.save(tp4);
			
		};
		
	}

}