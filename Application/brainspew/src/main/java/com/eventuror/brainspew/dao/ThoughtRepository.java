package com.eventuror.brainspew.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eventuror.brainspew.entities.Thought;
 
public interface ThoughtRepository extends CrudRepository<Thought, Long> {
	
	@Override
	public List<Thought> findAll();

}