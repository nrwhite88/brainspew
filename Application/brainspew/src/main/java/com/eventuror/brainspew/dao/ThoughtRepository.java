package com.eventuror.brainspew.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eventuror.brainspew.entities.Thought;
import com.eventuror.brainspew.relationships.ThoughtParentId;
 
public interface ThoughtRepository extends CrudRepository<Thought, Long> {
	
	@Override
		List<Thought> findAll();

	@Query(nativeQuery=true, value="SELECT thought_thought_id, parent_thought_id " + 
			"FROM thought_parent")
		public List<ThoughtParentId> thoughtParents();
	
	@Query(nativeQuery=true, value="SELECT order_id " + 
			"FROM thought_parent "
			+ "WHERE parent_id=?")
		public int parentOrder(int parentId);
}