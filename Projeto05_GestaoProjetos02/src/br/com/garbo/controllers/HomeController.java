package br.com.garbo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String iniciar() {
		return "menu"; //  //WEB-INF/views/menu.jsp
	}
}
