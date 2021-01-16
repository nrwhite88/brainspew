package com.eventuror.brainspew.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Thought {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long thoughtId;
	private String description;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
//	@OrderColumn
	@JoinTable(name="thought_parent",
			joinColumns=@JoinColumn(name="parent_id"),
			inverseJoinColumns=@JoinColumn(name="thought_id")
			)
	private List<Thought> children;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="thought_parent",
			joinColumns=@JoinColumn(name="thought_id"),
			inverseJoinColumns=@JoinColumn(name="parent_id")
			)
	private Thought parent;
	
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

	public List<Thought> getChildren() {
		return children;
	}

	public void setChildren(List<Thought> children) {
		this.children = children;
	}

	public Thought getParent() {
		return parent;
	}

	public void setParent(Thought parent) {
		this.parent = parent;
	}



}