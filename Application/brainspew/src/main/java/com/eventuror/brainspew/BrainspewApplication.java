package com.eventuror.brainspew;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eventuror.brainspew.dao.ThoughtRepository;
import com.eventuror.brainspew.dao.UserRepository;
import com.eventuror.brainspew.entities.Thought;
import com.eventuror.brainspew.entities.User;

@SpringBootApplication
public class BrainspewApplication {
	
	@Autowired
	ThoughtRepository thoughtRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BrainspewApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			User nick = new User("nickw",
					bCryptEncoder.encode("nickspw"), "USER");
			User becky = new User("beckym",
					bCryptEncoder.encode("beckyspw"), "USER");
			
			userRepo.save(nick);
			userRepo.save(becky);
//			
//			Thought thought2 = new Thought("Ferris Bueller Gets a Day Off", nick);
//			Thought thought4 = new Thought("George and Jerry must face off against him, for some reason", nick);
//			
//			Set<Thought> children3 = new HashSet<Thought>();
//			children3.add(thought4);
//			
//			Thought thought3 = new Thought("Turns out Kramer is a cybernetic organism "
//					+ "and doesn't actually know the meaning of friendship", null, children3, nick);
//			Thought thought5 = new Thought("Larry David is George's real father", nick);
//			
//			Set<Thought> children1 = new HashSet<Thought>();
//			children1.add(thought3);
//			children1.add(thought4);
//			Thought thought1 = new Thought("Alternate Seinfeld endings", null, children1, nick);
//			
//			thought3.setParent(thought1);
//			thought4.setParent(thought3);
//			thought5.setParent(thought1);
//			
//			thought1.setDepth();
//			thought2.setDepth();
//			thought3.setDepth();
//			thought4.setDepth();
//			thought5.setDepth();
//
//			thoughtRepo.save(thought1);
//			thoughtRepo.save(thought2);
//			thoughtRepo.save(thought3);
//			thoughtRepo.save(thought4);
//			thoughtRepo.save(thought5);
			
		};
		
	}

}