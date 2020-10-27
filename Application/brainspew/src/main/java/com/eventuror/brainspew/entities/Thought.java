package com.eventuror.brainspew.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thought {
	
	@Id
	private int thoughtId;
	private String thought;
	
	public int getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(int thoughtId) {
		this.thoughtId = thoughtId;
	}
	public String getThought() {
		return thought;
	}
	public void setThought(String thought) {
		this.thought = thought;
	}

}
