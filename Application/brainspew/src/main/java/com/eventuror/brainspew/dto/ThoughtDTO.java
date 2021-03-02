package com.eventuror.brainspew.dto;

import java.util.Set;

import com.eventuror.brainspew.entities.Thought;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class ThoughtDTO {

    public long thoughtId;
    public String description;
    public Thought parent;
    public Set<Thought> children;
    
	public ThoughtDTO(long thoughtId, String description, Thought parent, Set<Thought> children) {
		super();
		this.thoughtId = thoughtId;
		this.description = description;
		this.parent = parent;
		this.children = children;
	}
	public long getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(long thoughtId) {
		this.thoughtId = thoughtId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Thought getParent() {
		return parent;
	}
	public void setParent(Thought parent) {
		this.parent = parent;
	}
	public Set<Thought> getChildren() {
		return children;
	}
	public void setChildren(Set<Thought> children) {
		this.children = children;
	}
    

    
}