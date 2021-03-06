package com.eventuror.brainspew.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Thought {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long thoughtId;
	private String description;
	private int depth;
	
    @ManyToOne(fetch = FetchType.LAZY)
    private Thought parent;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Thought> children;
	
    public Set<Thought> getChildren() {
        return children;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
	private User user;
    
	public Thought() {
	}
	
	public Thought(String description, User user) {
		super();
		this.description = description;
		this.depth = 0;
		this.user = user;
	}

	public Thought(long thoughtId, String description, User user) {
		super();
		this.thoughtId = thoughtId;
		this.description = description;
		this.user = user;
	}

    public Thought(String description, Thought parent, User user) {
		super();
		this.description = description;
		this.parent = parent;
		this.user = user;
	}
    
    public Thought(String description, Thought parent, Set<Thought> children, User user) {
		super();
		this.description = description;
		this.parent = parent;
		this.children = children;
		this.user = user;
	}
	
    public Thought(String description, Thought parent, Set<Thought> children, int depth, User user) {
		super();
		this.description = description;
		this.parent = parent;
		this.children = children;
		this.depth = depth;
		this.user = user;
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

	public int getDepth() {
		return depth;
	}

	public void setDepth() {
		if (this.parent != null) {
			this.depth = this.parent.getDepth() + 1;
		}
		else {
			System.out.println(this.getDescription() + " is a root node!");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}