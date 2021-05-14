package br.com.garbo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.garbo.dao.GenericDao;
import br.com.garbo.entities.Prestador;

@Controller
public class PrestadoresController {
	@GetMapping("/prestadores/lista")
	public String listarPrestadores(ModelMap model) {
		try {
			GenericDao<Prestador> dao = new GenericDao<>(Prestador.class);
			List<Prestador> prestadores = dao.listar();
			model.addAttribute("listaPrestadores", prestadores);
			return "listas/listaPrestadores";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}	
}
