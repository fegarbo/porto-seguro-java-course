package br.com.garbo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItensController {
	
	@GetMapping("/itens/gestao")
	public String incluir(@RequestParam("idPedido") int idPedido, Model model) {
		return "";
	}
}
