package com.eventuror.brainspew.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Thought {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long thoughtId;
	private String description;
	
    @ManyToOne(fetch = FetchType.LAZY)
    private Thought parent;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
    private Set<Thought> children;
	
    public Set<Thought> getChildren() {
        return children;
    }
    
	public Thought() {
	}
	
	public Thought(String description) {
		super();
		this.description = description;
	}

	public Thought(long thoughtId, String description) {
		super();
		this.thoughtId = thoughtId;
		this.description = description;
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

	public void setChildren(Set<Thought> children) {
		this.children = children;
	}

}