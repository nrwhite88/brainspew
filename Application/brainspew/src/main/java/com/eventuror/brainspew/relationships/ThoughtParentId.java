package com.eventuror.brainspew.relationships;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ThoughtParentId
    implements Serializable {
 
    @Column(name = "thought_id")
    private long thoughtId;
 
    @Column(name = "parent_id")
    private long parentId;
 
    public ThoughtParentId() {}
 
    public ThoughtParentId(
        long thoughtId,
        long parentId) {
        this.thoughtId = thoughtId;
        this.parentId = parentId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ThoughtParentId that = (ThoughtParentId) o;
        return Objects.equals(thoughtId, that.thoughtId) &&
               Objects.equals(parentId, that.parentId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(thoughtId, parentId);
    }

	public long getThoughtId() {
		return thoughtId;
	}

	public long getParentId() {
		return parentId;
	}
    
}