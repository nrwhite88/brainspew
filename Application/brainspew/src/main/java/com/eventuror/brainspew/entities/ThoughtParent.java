package com.eventuror.brainspew.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eventuror.brainspew.relationships.ThoughtParentId;

@Entity(name = "ThoughtParent")
@Table(name = "thought_parent")
public class ThoughtParent {
 
    @EmbeddedId
    private ThoughtParentId id;
 
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("thoughtId")
    private Thought thought;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("parentId")
    private Thought parent;
 
    @Column(name = "order_id")
    private long orderId;
 
    private ThoughtParent() {}
 
    public ThoughtParent(Thought thought, Thought parent) {
    	this.thought = thought;
        this.parent = parent;
        this.id = new ThoughtParentId(thought.getThoughtId(), parent.getThoughtId());
    }
 
    public ThoughtParentId getId() {
		return id;
	}

	public void setId(ThoughtParentId id) {
		this.id = id;
	}

	public Thought getThought() {
		return thought;
	}

	public void setThought(Thought thought) {
		this.thought = thought;
	}

	public Thought getParent() {
		return parent;
	}

	public void setParent(Thought parent) {
		this.parent = parent;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ThoughtParent that = (ThoughtParent) o;
        return Objects.equals(thought, that.thought) &&
               Objects.equals(parent, that.parent);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(thought, parent);
    }
}