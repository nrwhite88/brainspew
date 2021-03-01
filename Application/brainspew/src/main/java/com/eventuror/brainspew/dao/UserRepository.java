package com.eventuror.brainspew.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eventuror.brainspew.entities.User;
 
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Override
	List<User> findAll();
	
}