package br.com.garbo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.garbo.dao.GenericDao;
import br.com.garbo.entities.Cliente;

@Controller
public class ClientesController {
	
	@RequestMapping("/clientes/lista")
	public String listarClientes(ModelMap model) {
		try {
			GenericDao<Cliente> dao = new GenericDao<>(Cliente.class);
			List<Cliente> clientes = dao.listar();
			model.addAttribute("listaClientes", clientes);
			return "listas/listaClientes";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
}
