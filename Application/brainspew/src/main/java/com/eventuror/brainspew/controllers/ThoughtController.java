package com.eventuror.brainspew.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventuror.brainspew.dao.ThoughtRepository;
import com.eventuror.brainspew.entities.Thought;
import com.eventuror.brainspew.relationships.ThoughtParentId;

@Controller
@RequestMapping("/thoughts")
public class ThoughtController {
	
	@Autowired
	ThoughtRepository thoughtRepo;
	
	@GetMapping("/list")
	public String displayThought(Model model) {
		
		List<Thought> thoughts = thoughtRepo.findAll();
		model.addAttribute("thoughtList", thoughts);
		
		return "thoughts/list-thoughts";
		
	}

	@GetMapping("/new-thought")
	public String newThought(Model model) {
		
		Thought thought = new Thought();
		
		model.addAttribute("thought", thought);
		
		return "thoughts/new-thought";
		
	}
	
	@PostMapping("/save-thought")
	public String createThought(Thought thought, Model model) {
		
		thoughtRepo.save(thought);
		
		return "redirect:/thoughts/list";
		
	}
	
	@GetMapping("/new-child")
	public String newChild(Model model) {
		
		Thought thought = new Thought();
		ThoughtParentId thoughtParentId = new ThoughtParentId();
		
		List<Thought> thoughts = thoughtRepo.findAll();
		List<ThoughtParentId> parents = thoughtRepo.thoughtParents();
		
		model.addAttribute("thought", thought);
		model.addAttribute("allThoughts", thoughts);
		model.addAttribute("parents", parents);
		
		return "thoughts/new-child";
		
	}
	
	@PostMapping("/save-child")
	public String createChild(Thought thought, Model model) {
		
		thoughtRepo.save(thought);
		
		return "redirect:/thoughts/list";
		
	}

}
