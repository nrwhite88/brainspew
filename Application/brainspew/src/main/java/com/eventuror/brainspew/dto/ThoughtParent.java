package com.eventuror.brainspew.dto;

import com.eventuror.brainspew.entities.Thought;

public interface ThoughtParent {
		
		public long getThoughtId();
		public long getParentId();
		public long getOrderId();

}