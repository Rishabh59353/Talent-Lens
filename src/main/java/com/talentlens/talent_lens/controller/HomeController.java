package com.talentlens.talent_lens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		System.out.println("HomeController is called");
		return "index";
	}
}
