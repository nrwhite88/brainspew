package com.eventuror.brainspew.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventuror.brainspew.dao.ThoughtRepository;
import com.eventuror.brainspew.entities.Thought;

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
		
		List<Thought> thoughts = thoughtRepo.findAll();
		
		model.addAttribute("thought", thought);
		model.addAttribute("thoughts", thoughts);
		
		return "thoughts/new-child";
		
	}
	
	@PostMapping("/save-child")
	public String createChild(Thought thought, Model model) {
		
		thoughtRepo.save(thought);
		
		return "redirect:/thoughts/list";
		
	}
	
	@GetMapping("/list-children")
	public String displayChildren(Model model) {
		
		List<Thought> rootThoughtList = thoughtRepo.findByParentIsNull();
		List<Thought> resultsList = new ArrayList<Thought>();
		for (Thought thought : rootThoughtList) {
		    recursiveTree(thought, resultsList);
		}
		
		for (Thought t : resultsList) {
			System.out.println(t.getDescription());
		}
		
		model.addAttribute("rootThoughtList", rootThoughtList);
		
		return "thoughts/list-children";
		
	}
	
	@GetMapping("/list-roots")
	public String displayRoots(Model model) {
		
		List<Thought> rootThoughtList = thoughtRepo.findByParentIsNull();
		
		model.addAttribute("rootThoughtList", rootThoughtList);
		
		return "thoughts/list-roots";
		
	}
	
	@GetMapping("/list-children/{id}")
	public String displayChildrenByRootId(Model model, @PathVariable String id) {
		
		List<Object> rootAndChildren = getRootAndChildrenByRootId(id);
		
		Thought root = (Thought) rootAndChildren.get(0);
		List<Thought> children = (List<Thought>) rootAndChildren.get(1);
		
		model.addAttribute("root", root);
		model.addAttribute("children", children);
		
		return "thoughts/list-root-children";
		
	}
	
	public List<Object> getRootAndChildrenByRootId(String id) { 
		
		List<Thought> rootChildrenList = thoughtRepo.findChildrenByParentId(id);
		List<Thought> resultsList = new ArrayList<Thought>();
		for (Thought thought : rootChildrenList) {
		    recursiveTree(thought, resultsList);
		}
		
		for (Thought t : resultsList) {
			System.out.println(t.getDescription());
		}
		
		Thought root = thoughtRepo.findThoughtById(id).get(0);
		
		List<Object> rootAndChildren = new ArrayList<Object>();
		rootAndChildren.add(root);
		rootAndChildren.add(resultsList);
		
		return rootAndChildren;
		
	}
	
	public void recursiveTree(Thought thought, List<Thought> resultsList) {
        //System.out.println(thought.getDescription());
		resultsList.add(thought);
        if (thought.getChildren().size() > 0) {
            for (Thought t : thought.getChildren()) {
                recursiveTree(t, resultsList);
            }
        }
    }

}
