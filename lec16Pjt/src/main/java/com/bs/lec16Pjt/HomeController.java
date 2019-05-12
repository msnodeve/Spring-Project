package com.bs.lec16Pjt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		System.out.println("home Method");
		model.addAttribute("key","Home value");
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		System.out.println("login Method");
		model.addAttribute("key","Login value");
		return "login";
	}
}
