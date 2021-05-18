package br.com.garbo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.garbo.dao.GenericDao;
import br.com.garbo.dao.MetodosDao;
import br.com.garbo.entities.Cliente;
import br.com.portoseguro.viewmodels.ClientesProjetosVM;

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
	
	@RequestMapping("/clientes/listaProjetos")
	public ModelAndView listarProjetosPorCliente(Model model) {
		try {
			List<ClientesProjetosVM> clienteProjetos = new MetodosDao().listarQtdeProjetos();
			model.addAttribute("listaQtdeClientes", clienteProjetos);
			return new ModelAndView("listas/listaQtdeProjetos");
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}		
	}
}
