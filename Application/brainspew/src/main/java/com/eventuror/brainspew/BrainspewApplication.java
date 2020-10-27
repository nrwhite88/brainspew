package com.eventuror.brainspew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventuror.brainspew.dao.ThoughtRepository;

@SpringBootApplication
public class BrainspewApplication {
	
	@Autowired
	ThoughtRepository thoughtRepo;

	public static void main(String[] args) {
		SpringApplication.run(BrainspewApplication.class, args);
	}

}