package br.com.garbo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.garbo.dao.ClientesDao;
import br.com.garbo.models.Cliente;

@Controller
public class ClientesController {
	
	@Autowired
	private ClientesDao clientesDao;
	
	@GetMapping("/clientes/cadastro")
	public ModelAndView incluir(Model model) {
		try {
			return new ModelAndView("clientes/cadastroClientes");
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}
	}
	
	@PostMapping("/cadCliente")
	public ModelAndView incluir(Cliente cliente, Model model) {
		try {
			clientesDao.incluir(cliente);
			Collection<Cliente> clientes = clientesDao.listar();
			model.addAttribute("clientes", clientes);
			return new ModelAndView("clientes/listaClientes");
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}
	}
}
