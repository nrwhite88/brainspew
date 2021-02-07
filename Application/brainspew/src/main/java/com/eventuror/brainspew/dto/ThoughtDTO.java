package com.eventuror.brainspew.dto;

import java.util.Set;

import com.eventuror.brainspew.entities.Thought;

public class ThoughtDTO {

    public long thoughtId;
    public String description;
    public Thought parent;
    public Set<Thought> children;
    
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