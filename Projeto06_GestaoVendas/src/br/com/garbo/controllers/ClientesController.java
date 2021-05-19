package br.com.garbo.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			model.addAttribute("cliente", new Cliente());
			return new ModelAndView("clientes/cadastroClientes");
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}
	}
	
	@PostMapping("/cadCliente")
	public ModelAndView incluir(
			@Valid
			@ModelAttribute("cliente") Cliente cliente,
			BindingResult result,
			Model model) {				
		try {
			if (result.hasErrors()) {
				model.addAttribute("cliente", cliente);
				return new ModelAndView("clientes/cadastroClientes");
			} else {
				clientesDao.incluir(cliente);
				return new ModelAndView("redirect:/clientes/lista");
			}
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return new ModelAndView("erro");
		}
	}
	
	@GetMapping("/clientes/alteracao/{documento}")
	public String alterar(@PathVariable("documento") String documento, Model model) {
		try {
			Cliente cliente = clientesDao.buscar(documento);
			if (cliente == null) {
				throw new Exception("Nenhum cliente encontrado com este documento.");
			}
			
			model.addAttribute("cliente", cliente);
			return "clientes/alteracaoClientes";			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("clientes/lista")
	public String listar(Model model) {
		try {
			Collection<Cliente> clientes = clientesDao.listar();
			model.addAttribute("clientes", clientes);
			return "clientes/listaClientes";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/alteracliente")
	public String alterar(
			@Valid @ModelAttribute("cliente") Cliente cliente,
			BindingResult result,
			Model model) {
		try {
			if (result.hasErrors()) {
				//model.addAttribute("cliente", cliente);
				return "clientes/alteracaoClientes";
			} else {
				clientesDao.alterar(cliente);
				return "redirect:/clientes/lista";
			}
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
	
	
	
}
