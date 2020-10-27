package com.eventuror.brainspew.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thoughts")
public class ThoughtController {
	
	@GetMapping("/list-thoughts")
	public String displayThoughtBubbles(Model model) {
		
		return "thoughts/list-thoughts";
		
	}

}