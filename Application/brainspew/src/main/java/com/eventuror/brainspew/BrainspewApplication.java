package com.eventuror.brainspew;

import java.util.HashSet;
import java.util.Set;

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
			
			Thought thought2 = new Thought("Ferris Bueller Gets a Day Off");
			Thought thought4 = new Thought("Jerry, inconsolable, overdoses on crystal meth");
			Set<Thought> children3 = new HashSet<Thought>();
			children3.add(thought4);
			Thought thought3 = new Thought("George gets hit by a bus", null, children3);
			Set<Thought> children1 = new HashSet<Thought>();
			children1.add(thought3);
			children1.add(thought4);
			Thought thought1 = new Thought("Alternate Seinfeld endings", null, children1);
			thought3.setParent(thought1);
			thought4.setParent(thought3);

			thoughtRepo.save(thought1);
			thoughtRepo.save(thought2);
			thoughtRepo.save(thought3);
			thoughtRepo.save(thought4);
//			thoughtRepo.save(tp1);
//			thoughtRepo.save(tp2);
//			thoughtRepo.save(tp3);
//			thoughtRepo.save(tp4);
			
		};
		
	}

}