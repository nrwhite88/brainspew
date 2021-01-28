package com.eventuror.brainspew.entities;

import java.util.List;
import java.util.Objects;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Entity
@NaturalIdCache
@Cache(
	    usage = CacheConcurrencyStrategy.READ_WRITE
	)
public class Thought {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long thoughtId;
	@NaturalId
	private String description;
	
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thought thought = (Thought) o;
        return Objects.equals(description, thought.description);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

}